package com.UMCfront.religo.src.main.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.data.CommunityArticleResponse
import com.UMCfront.religo.src.main.community.data.CommunityArticleRetrofitInterface
import com.UMCfront.religo.src.main.community.data.model.CommunityUserInfoResponse
import com.UMCfront.religo.src.main.home.HomeFragment
import com.UMCfront.religo.src.main.home.data.ChurchRecommendRetrofitService
import com.UMCfront.religo.src.main.home.data.HomeCommunityRetrofitService
import com.UMCfront.religo.src.main.home.data.model.HomeCommunityResponse
import retrofit2.Call
import retrofit2.Response


class CommunityFragment : Fragment() {

    val communityAllArticleList= mutableListOf<CommunityItem>()
    val communityPlatformArticleList= mutableListOf<CommunityItem>()
    val communityChurchFragment:CommunityChurchFragment= CommunityChurchFragment()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)



        val churchEntrance=view.findViewById<ImageView>(R.id.community_entrance)

        // 내 교회 정보
        val retrofit= ApplicationClass.sRetrofit
        val communityService=retrofit.create(CommunityArticleRetrofitInterface::class.java)
        var churchId:Int=1;
        val platformCode:String=""

        communityService.getUserInfo().enqueue(object :retrofit2.Callback<CommunityUserInfoResponse>{
            override fun onResponse(
                call: Call<CommunityUserInfoResponse>,
                response: Response<CommunityUserInfoResponse>
            ) {
                val res=response.body() as CommunityUserInfoResponse
                val userName=view.findViewById<TextView>(R.id.community_name1)
                val churchName=view.findViewById<TextView>(R.id.community_churchName)
                val churchAddress=view.findViewById<TextView>(R.id.community_church_address)
                userName.text=res.result.name
                churchName.text=res.result.churchName
                churchAddress.text=res.result.churchAddress
                churchId= res.result.churchId.toInt()
                //교단코드

                churchEntrance!!.setOnClickListener {

                    // fragment간 이동

                    val bundle:Bundle=Bundle()
                    bundle.putInt("churchId",churchId)
                    communityChurchFragment.arguments=bundle
                    (activity as MainActivity?)?.changeFragment(communityChurchFragment)



                }

            }

            override fun onFailure(call: Call<CommunityUserInfoResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
            }
        })




        // 커뮤니티 글 찾아오기

        communityService.getCommunityAll().enqueue(object :retrofit2.Callback<CommunityArticleResponse>{
            override fun onResponse(
                call: Call<CommunityArticleResponse>,
                response: Response<CommunityArticleResponse>
            ) {
                val res=response.body() as CommunityArticleResponse
                System.out.println(res)
                communityAllArticleList.clear()

                for(item in res.result){
                    communityAllArticleList.add(CommunityItem(item.title,item.recently))
                }

                val allViewMore=view.findViewById<ImageView>(R.id.community_all_viewmore)

                allViewMore.setOnClickListener{
                    val bundle:Bundle=Bundle()
                    bundle.putInt("churchId",churchId)
                    Log.d("ccc",churchId.toString())
                    CommunityAllFragment.newInstance().arguments=bundle

                    (activity as MainActivity?)?.changeFragment(CommunityAllFragment.newInstance())

//            activity?.let{
//                val intent = Intent(context, CommunityAllActivity::class.java)
//                startActivity(intent)
//
//            }
                }

                val rv=view.findViewById<RecyclerView>(R.id.allRV)

                val communityAdapter= CommunityRVAdapter1(communityAllArticleList)
                rv.adapter=communityAdapter
                rv.layoutManager= LinearLayoutManager(context)

                // 글 클릭 구현
                communityAdapter.itemClick=object:CommunityRVAdapter1.ItemClick{
                    override fun onClick(view: View, position: Int) {
                        (activity as MainActivity?)?.changeFragment(CommunityAllArticleFragment.newInstance())
                    }

                }

            }

            override fun onFailure(call: Call<CommunityArticleResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
            }
        })




        //교단 보기
        communityService.getCommunityPlatform("PA1").enqueue(object :retrofit2.Callback<CommunityArticleResponse>{
            override fun onResponse(
                call: Call<CommunityArticleResponse>,
                response: Response<CommunityArticleResponse>
            ) {
                val res=response.body() as CommunityArticleResponse
                System.out.println(res)
                Log.d("home2", res.result.size.toString())
                //communityPlatformArticleList.clear()

                for(item in res.result){
                    communityPlatformArticleList.add(CommunityItem(item.title,item.recently))
                }

                val platformMore=view.findViewById<ImageView>(R.id.community_platform_viewmore)

                platformMore.setOnClickListener {
                    (activity as MainActivity?)?.changeFragment(CommunityPlatformFragment.newInstance())
                }






                val platformAdapter= CommunityRVAdapter1(communityPlatformArticleList)
                val platRv=view.findViewById<RecyclerView>(R.id.platformRV)

                platRv.adapter=platformAdapter

                // 글 클릭 구현
                platformAdapter.itemClick=object:CommunityRVAdapter1.ItemClick{
                    override fun onClick(view: View, position: Int) {
                        (activity as MainActivity?)?.changeFragment(CommunityPlatformFragment.newInstance())
                    }

                }

            }

            override fun onFailure(call: Call<CommunityArticleResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
            }
        })




    }

    companion object {
        // fragment 인스턴스 사용하기 위해 companion object 사용
        fun newInstance(): CommunityFragment {
            return CommunityFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }

    inner class CommunityDetail constructor(title:String,text:String){
        var title:String = ""
        var text:String=""
        var hearCount:Int=0

        init{
            this.title=title
            this.text=text
        }

    }
    inner class CommunityItem constructor(title:String,recently:Boolean){
        var title:String=""
        var recently:Boolean=true
        init{
            this.title=title
            this.recently=recently
        }
    }


}