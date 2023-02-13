package com.UMCfront.religo.src.main.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.databinding.FragmentCommunityChurchBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityAdapterChruch
import com.UMCfront.religo.src.main.community.data.CommunityArticleResponse
import com.UMCfront.religo.src.main.community.data.CommunityArticleRetrofitInterface
import retrofit2.Call
import retrofit2.Response


class CommunityChurchFragment : Fragment() {

    val communityChurchArticleList= mutableListOf<CommunityChurchDetail>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_community_church, container, false)
        val binding = FragmentCommunityChurchBinding.inflate(inflater, container, false)
        val churchId=requireArguments().getInt("churchId")
        Log.d("church**",churchId.toString())

        // church id를 파라미터로 넣어서 값 받아오기
        val retrofit= ApplicationClass.sRetrofit
        val communityChurchService=retrofit.create(CommunityArticleRetrofitInterface::class.java)

        communityChurchService.getCommunityChurch(churchId).enqueue(object :retrofit2.Callback<CommunityArticleResponse>{
            override fun onResponse(
                call: Call<CommunityArticleResponse>,
                response: Response<CommunityArticleResponse>
            ) {
                val res=response.body() as CommunityArticleResponse
                Log.d("home222",res.result.size.toString())
                //communityAllArticleList.clear()


                for(item in res.result){
                    System.out.println(item.title)
                    communityChurchArticleList.add(
                        CommunityChurchDetail(
                            item.articleId,
                            item.title.toString(),
                            item.text.toString(),
                            item.heartCnt
                        )
                    )
                }




                val communityAdapter= CommunityAdapterChruch(communityChurchArticleList)

                System.out.println(communityChurchArticleList.size)
                //community_grid_rv
                val rv= binding.communityGridRv
                rv.adapter=communityAdapter


                rv.layoutManager= LinearLayoutManager(context)
                // 글 클릭 구현
                communityAdapter.itemClick=object: CommunityAdapterChruch.GridItemClick{
                    override fun onClick(view: View, position: Int) {
                        val communityChurchArticleFragment=CommunityChurchArticleFragment()
                        val bundle:Bundle=Bundle()
                        bundle.putInt("articleId",communityChurchArticleList[position].articleId)
                        communityChurchArticleFragment.arguments=bundle
                        (activity as MainActivity?)?.changeFragment(communityChurchArticleFragment)
                    }

                }
                binding.communityFab.bringToFront()

                // 글쓰기 버튼 구현


                binding.communityFab.setOnClickListener{

                    Toast.makeText(context,"플로팅 클릭", Toast.LENGTH_LONG).show()

                    (activity as MainActivity?)?.changeFragment(CommunityChurchWritingFragment.newInstance())

                }


                //뒤로가기 버튼 구현
                binding.communityChurchBack.setOnClickListener{
                    (activity as MainActivity?)?.changeFragment(CommunityFragment.newInstance())

                }

                binding.communityFab.bringToFront()

                // 글쓰기 버튼 구현


                binding.communityFab.setOnClickListener{

                    Toast.makeText(context,"플로팅 클릭", Toast.LENGTH_LONG).show()

                    (activity as MainActivity?)?.changeFragment(CommunityChurchWritingFragment.newInstance())

                }


                //뒤로가기 버튼 구현
                binding.communityChurchBack.setOnClickListener{
                    (activity as MainActivity?)?.changeFragment(CommunityFragment.newInstance())

                }



            }

            override fun onFailure(call: Call<CommunityArticleResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
            }
        })

        return binding.root




    }

    companion object {
        fun newInstance(): CommunityChurchFragment {
            return CommunityChurchFragment()
        }
    }

    inner class CommunityChurchDetail(articleId:Int,title: String, text: String, heartCnt: Int){
        var articleId:Int=0
        var title:String = ""
        var text:String=""
        var hearCount:Int=0

        init{
            this.articleId=articleId
            this.title=title
            this.text=text
            this.hearCount=hearCount
        }

    }
}