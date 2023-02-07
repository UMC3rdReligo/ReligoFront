package com.UMCfront.religo.src.main.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.databinding.FragmentCommunityChurchBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter
import com.UMCfront.religo.src.main.community.data.CommunityArticleResponse
import com.UMCfront.religo.src.main.community.data.CommunityArticleRetrofitInterface
import retrofit2.Call
import retrofit2.Response


class CommunityChurchFragment : Fragment() {

    private var _binding: FragmentCommunityChurchBinding? = null
    private val binding get() = _binding!!
    val communityChurchArticleList= mutableListOf<CommunityChurchDetail>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val churchId=requireArguments().getLong("churchId")
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
                Log.d("home2",res.result.size.toString())
                //communityAllArticleList.clear()

                for(item in res.result){
                    communityChurchArticleList.add(
                        CommunityChurchDetail(
                            item.title,
                            item.text.substring(0,20),
                            item.heartCnt
                        )
                    )
                }
            }

            override fun onFailure(call: Call<CommunityArticleResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
            }
        })

        val binding = FragmentCommunityChurchBinding.inflate(inflater, container, false)


        val communityAdapter= CommunityGridAdapter(communityChurchArticleList)

        //community_grid_rv
        val rv=binding.communityGridRv
        rv.adapter=communityAdapter


        rv.layoutManager= LinearLayoutManager(this.context)

        binding.communityFab.bringToFront()

        // 글쓰기 버튼 구현


        binding.communityFab.setOnClickListener{

            Toast.makeText(context,"플로팅 클릭", Toast.LENGTH_LONG).show()

            (activity as MainActivity?)?.changeFragment(CommunityChurchWritingFragment.newInstance())

        }
        // 글 클릭 구현
        communityAdapter.itemClick=object: CommunityGridAdapter.GridItemClick{
            override fun onClick(view: View, position: Int) {
                (activity as MainActivity?)?.changeFragment(CommunityChurchArticleFragment.newInstance())
            }

        }

        //뒤로가기 버튼 구현
        binding.communityChurchBack.setOnClickListener{
            (activity as MainActivity?)?.changeFragment(CommunityFragment.newInstance())

        }

        return binding.root

    }

    companion object {
        fun newInstance(): CommunityChurchFragment {
            return CommunityChurchFragment()
        }
    }

    inner class CommunityChurchDetail(title: String, text: String, heartCnt: Int){
        var title:String = ""
        var text:String=""
        var hearCount:Int=0

        init{
            this.title=title
            this.text=text
            this.hearCount=hearCount
        }

    }
}