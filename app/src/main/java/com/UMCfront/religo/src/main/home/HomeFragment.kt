package com.UMCfront.religo.src.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

import androidx.viewpager2.widget.ViewPager2
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.church.HomechurchinfoFragment
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1
import com.UMCfront.religo.src.main.home.adapter.HomeViewPagerAdapter
import com.UMCfront.religo.src.main.home.data.ChurchRecommendRetrofitService
import com.UMCfront.religo.src.main.home.data.model.ChurchRecommendResponse
import retrofit2.Call
import retrofit2.Response


class HomeFragment : Fragment(){

    val homechurchinfoFragment=HomechurchinfoFragment();
    val churchRecommendList= mutableListOf<HomeChurchViewItem>()
    val churchItemDetailList= mutableListOf<HomeChurchItemDetail>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_home, container, false)

        //


        // home- 교회추천 viewpager
        val viewPager2Church = view.findViewById<ViewPager2>(R.id.home_churchrecommend_viewpager);

        val retrofit=ApplicationClass.sRetrofit
        val service=retrofit.create(ChurchRecommendRetrofitService::class.java)

        service.getChurchRecommendation().enqueue(object :retrofit2.Callback<ChurchRecommendResponse>{
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
                            info.name,
                            info.address,
                            item.mainImage
                        )
                    )

                }
                for(i in 0..churchItemDetailList.size-1 step 2){
                    churchRecommendList.add(HomeChurchViewItem(churchItemDetailList.get(i),churchItemDetailList.get(i+1)))

                }
                val churchViewPagerAdapter= HomeViewPagerAdapter(churchRecommendList)
                viewPager2Church.adapter= churchViewPagerAdapter
                // 더 알아보기 클릭

                churchViewPagerAdapter.churchItemClick=object :HomeViewPagerAdapter.ChurchViewMoreItemClick{
                    override fun onClick(view: View, position: Int) {
                        (activity as MainActivity?)?.changeFragment(homechurchinfoFragment)
                    }
                }
            }

            override fun onFailure(call: Call<ChurchRecommendResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류",Toast.LENGTH_LONG).show()
            }
        })





        val homeCommunityList= mutableListOf<String>()
        homeCommunityList.add("안녕하세용~~")
        homeCommunityList.add("안녕하세용~~")
        homeCommunityList.add("안녕하세용~~")
        homeCommunityList.add("안녕하세용~~")
        homeCommunityList.add("안녕하세용~~")




        val communityRecyclerView=view.findViewById<RecyclerView>(R.id.home_community_allRV)
        communityRecyclerView.adapter=CommunityRVAdapter1(homeCommunityList)


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

    inner class HomeChurchItemDetail constructor(name:String,address:String,mainImg:String){
        var name:String=""
        var address:String=""
        var mainImg:String=""
        init{
            this.name=name;
            this.address=address;
            this.mainImg=mainImg
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


