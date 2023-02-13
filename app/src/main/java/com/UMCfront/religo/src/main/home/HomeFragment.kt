package com.UMCfront.religo.src.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import androidx.viewpager2.widget.ViewPager2
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.church.HomeChurchsignupFragment
import com.UMCfront.religo.src.main.church.HomechurchinfoFragment
import com.UMCfront.religo.src.main.community.CommunityAllFragment
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1
import com.UMCfront.religo.src.main.community.data.CommunityArticleRetrofitInterface
import com.UMCfront.religo.src.main.home.adapter.HomeCommunityRVAdapter
import com.UMCfront.religo.src.main.home.adapter.HomeViewPagerAdapter
import com.UMCfront.religo.src.main.home.adapter.HomeViewPagerAdapter2
import com.UMCfront.religo.src.main.home.data.ChurchRecommendRetrofitService
import com.UMCfront.religo.src.main.home.data.HomeCommunityRetrofitService
import com.UMCfront.religo.src.main.home.data.HomeEventRetrofitService
import com.UMCfront.religo.src.main.home.data.HomeUserInfoRetrofitInterface
import com.UMCfront.religo.src.main.home.data.model.ChurchRecommendResponse
import com.UMCfront.religo.src.main.home.data.model.HomeCommunityResponse
import com.UMCfront.religo.src.main.home.data.model.HomeEventResponse
import com.UMCfront.religo.src.main.home.data.model.HomeUserInfoResponse
import retrofit2.Call
import retrofit2.Response
import retrofit2.create


class HomeFragment : Fragment(){

    val homechurchinfoFragment=HomechurchinfoFragment();
    val churchRecommendList= mutableListOf<HomeChurchViewItem>()
    val churchItemDetailList= mutableListOf<HomeChurchItemDetail>()
    val homeCommunityItemList=ArrayList<HomeCommunity>(10)
    val homeEventList= mutableListOf<HomeEventDetail>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_home, container, false)

        //유저 정보 받아오기
        val retrofit= ApplicationClass.sRetrofit
        val homeUserService=retrofit.create(HomeUserInfoRetrofitInterface::class.java)
        homeUserService.getHomeUserInfo().enqueue(object :retrofit2.Callback<HomeUserInfoResponse>{
            override fun onResponse(
                call: Call<HomeUserInfoResponse>,
                response: Response<HomeUserInfoResponse>
            ) {
                val res=response.body() as HomeUserInfoResponse
                val locate=view.findViewById<TextView>(R.id.home_locate_textview)
                val result=res.result
                Log.d("address*",result.userAddress2)
                locate.text=result.userAddress2.toString()
            }

            override fun onFailure(call: Call<HomeUserInfoResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류",Toast.LENGTH_LONG).show()
            }
        })


        // home- 교회추천 viewpager
        val viewPager2Church = view.findViewById<ViewPager2>(R.id.home_churchrecommend_viewpager);
        val churchService=retrofit.create(ChurchRecommendRetrofitService::class.java)

        churchService.getChurchRecommendation().enqueue(object :retrofit2.Callback<ChurchRecommendResponse>{
            override fun onResponse(
                call: Call<ChurchRecommendResponse>,
                response: Response<ChurchRecommendResponse>
            ) {
                val res=response.body() as ChurchRecommendResponse

                Log.d("home",res.result.get(0).info.name)

                for(item in res.result) {
                    val info = item.info
                    churchItemDetailList.add(
                        HomeChurchItemDetail(
                            info.id,
                            info.name,
                            info.address,
                            item.mainImage
                        )
                    )

                }
                for(i in 0..churchItemDetailList.size-2 step 2){
                    churchRecommendList.add(HomeChurchViewItem(churchItemDetailList.get(i),churchItemDetailList.get(i+1)))

                }
                val churchViewPagerAdapter= HomeViewPagerAdapter(churchRecommendList)
                viewPager2Church.adapter= churchViewPagerAdapter
                // 더 알아보기 클릭

                churchViewPagerAdapter.churchItemClick1=object :HomeViewPagerAdapter.ChurchViewMoreItemClick{
                    override fun onClick(view: View, position: Int) {
                        Log.d("home3",churchRecommendList.get(position).church1.churchId.toString())
                        val bundle:Bundle=Bundle()
                        bundle.putInt("churchId",churchRecommendList[position].church1.churchId)
                        homechurchinfoFragment.arguments=bundle
                        HomeChurchsignupFragment().arguments=bundle

                        Log.d("home3.5","dd")
                        (activity as MainActivity?)?.changeFragment(homechurchinfoFragment)
                    }
                }
                churchViewPagerAdapter.churchItemClick2=object :HomeViewPagerAdapter.ChurchViewMoreItemClick{
                    override fun onClick(view: View, position: Int) {
                        val bundle:Bundle=Bundle()
                        bundle.putInt("churchId",churchRecommendList[position].church2.churchId)
                        homechurchinfoFragment.arguments=bundle
                        HomeChurchsignupFragment().arguments=bundle
                        (activity as MainActivity?)?.changeFragment(homechurchinfoFragment)
                    }
                }
            }

            override fun onFailure(call: Call<ChurchRecommendResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류",Toast.LENGTH_LONG).show()
            }
        })


        // 커뮤니티 글 찾아오기
        val communityService=retrofit.create(HomeCommunityRetrofitService::class.java)
        communityService.getHomeCommunityAll().enqueue(object :retrofit2.Callback<HomeCommunityResponse>{
            override fun onResponse(
                call: Call<HomeCommunityResponse>,
                response: Response<HomeCommunityResponse>
            ) {
                val res=response.body() as HomeCommunityResponse
                Log.d("home2",res.result.size.toString())
                homeCommunityItemList.clear()

                for(item in res.result){
                    homeCommunityItemList.add(HomeCommunity(item.title,item.recently))
                }
            }

            override fun onFailure(call: Call<HomeCommunityResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류",Toast.LENGTH_LONG).show()
            }
        })

        // 커뮤니티 더 알아보기 눌렀을 때 전체 커뮤니티 화면으로 이동되게끔

        val home_community_view_more=view.findViewById<ImageView>(R.id.home_community_viewmore)
        home_community_view_more.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityAllFragment())

        }

        val communityRecyclerView=view.findViewById<RecyclerView>(R.id.home_community_allRV)
        communityRecyclerView.adapter=HomeCommunityRVAdapter(homeCommunityItemList)

        homeEventList.add(HomeEventDetail("부활절 행사","서울특별시 양천 목동 중앙본로  51-16","https://mblogthumb-phinf.pstatic.net/MjAxODAzMjlfNDgg/MDAxNTIyMzI2ODE5MTkx.qDy6e-7CD8o7a3bbozdVX3c3X7d4BEuzZ_kHgz3LWTYg.KBcLyTPcBAB0IsetRbUAqkQuKHfLZ2cS0yBFL7BJnCUg.JPEG.myday5676/18-03-29-21-33-04-226_deco.jpg?type=w800"))
        homeEventList.add(HomeEventDetail("부활절 행사","서울특별시 양천 목동 중앙본로  51-16","https://mblogthumb-phinf.pstatic.net/MjAxODAzMjlfNDgg/MDAxNTIyMzI2ODE5MTkx.qDy6e-7CD8o7a3bbozdVX3c3X7d4BEuzZ_kHgz3LWTYg.KBcLyTPcBAB0IsetRbUAqkQuKHfLZ2cS0yBFL7BJnCUg.JPEG.myday5676/18-03-29-21-33-04-226_deco.jpg?type=w800"))
        homeEventList.add(HomeEventDetail("부활절 행사","서울특별시 양천 목동 중앙본로  51-16","https://mblogthumb-phinf.pstatic.net/MjAxODAzMjlfNDgg/MDAxNTIyMzI2ODE5MTkx.qDy6e-7CD8o7a3bbozdVX3c3X7d4BEuzZ_kHgz3LWTYg.KBcLyTPcBAB0IsetRbUAqkQuKHfLZ2cS0yBFL7BJnCUg.JPEG.myday5676/18-03-29-21-33-04-226_deco.jpg?type=w800"))


        // 이벤트
        val eventService=retrofit.create(HomeEventRetrofitService::class.java)
        eventService.getHomeEvent().enqueue(object :retrofit2.Callback<HomeEventResponse>{
            override fun onResponse(
                call: Call<HomeEventResponse>,
                response: Response<HomeEventResponse>
            ) {
                val res=response.body() as HomeEventResponse

                homeEventList.clear()

                for(item in res.result.infos){
                    homeEventList.add(HomeEventDetail(item.eventName,item.location,item.eventImage[0]))
                }
                val eventViewPager=view.findViewById<ViewPager2>(R.id.home_event_all_view_pager)
                eventViewPager.adapter=HomeViewPagerAdapter2(homeEventList)
            }

            override fun onFailure(call: Call<HomeEventResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류",Toast.LENGTH_LONG).show()
            }
        })




        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    // church view pager 객체 지정

    inner class HomeChurchViewItem constructor(church1:HomeChurchItemDetail,church2:HomeChurchItemDetail){


        lateinit var church1:HomeChurchItemDetail
        lateinit var church2:HomeChurchItemDetail

        init{
            this.church1=church1
            this.church2=church2

        }



    }

    inner class HomeChurchItemDetail constructor(churchId:Int,name:String,address:String,mainImg:String){
        var churchId:Int=0
        var name:String=""
        var address:String=""
        var mainImg:String=""
        init{
            this.churchId=churchId
            this.name=name;
            this.address=address;
            this.mainImg=mainImg
        }
    }

    inner class HomeEventDetail constructor(name:String,location:String,mainImg:String){
        var name:String=""
        var location:String=""
        var mainImg:String=""
        init{
            this.name=name
            this.location=location
            this.mainImg=mainImg
        }
    }

    // 커뮤니티 객체 지정

    inner class HomeCommunity constructor(title:String,recently:Boolean){
        var title:String=""
        var recently:Boolean=true
        init{
            this.title=title
            this.recently=recently
        }
    }





    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}

private fun <T> Call<T>.enqueue(any: Any) {

}


