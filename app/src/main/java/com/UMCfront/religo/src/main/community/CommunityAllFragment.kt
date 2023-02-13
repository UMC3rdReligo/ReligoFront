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
import com.UMCfront.religo.databinding.FragmentCommunityAllBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityAdapterAll
import com.UMCfront.religo.src.main.community.data.CommunityArticleResponse
import com.UMCfront.religo.src.main.community.data.CommunityArticleRetrofitInterface
import retrofit2.Call
import retrofit2.Response


class CommunityAllFragment : Fragment() {
    private var _binding: FragmentCommunityAllBinding? = null
    private val binding get() = _binding!!
    val communityAllList= mutableListOf<CommunityAllDetail>()
    val communityAllArticleFragment=CommunityAllArticleFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        


        val binding = FragmentCommunityAllBinding.inflate(inflater, container, false)
        val retrofit= ApplicationClass.sRetrofit
        val communityChurchService=retrofit.create(CommunityArticleRetrofitInterface::class.java)

        communityChurchService.getCommunityAll().enqueue(object :retrofit2.Callback<CommunityArticleResponse>{
            override fun onResponse(
                call: Call<CommunityArticleResponse>,
                response: Response<CommunityArticleResponse>
            ) {
                val res=response.body() as CommunityArticleResponse
                Log.d("home2",res.result.size.toString())
                //communityAllArticleList.clear()

                for(item in res.result){
                    communityAllList.add(
                        CommunityAllDetail(
                            item.articleId,
                            item.title,
                            item.text,
                            item.heartCnt
                        )
                    )
                }

                val communityAllAdapter= CommunityAdapterAll(communityAllList)

                //community_grid_rv
                val rv=binding.communityGridRv
                rv.adapter=communityAllAdapter


                //linear layout으로 변경
                rv.layoutManager= LinearLayoutManager(context)
                rv.layoutManager= LinearLayoutManager(context)

                binding.communityFab.bringToFront()

                // 글쓰기 버튼 구현
                binding.communityFab.setOnClickListener{

                    Toast.makeText(context,"플로팅 클릭", Toast.LENGTH_LONG).show()

                    (activity as MainActivity?)?.changeFragment(CommunityAllWritingFragment.newInstance())

                }


                // 글 클릭 구현
                communityAllAdapter.itemClick=object: CommunityAdapterAll.AllItemClick{
                    override fun onClick(view: View, position: Int) {
                        val bundle:Bundle=Bundle()
                        bundle.putInt("articleId",communityAllList[position].articleId)
                        communityAllArticleFragment.arguments=bundle
                        (activity as MainActivity?)?.changeFragment(communityAllArticleFragment)
                    }

                }
            }

            override fun onFailure(call: Call<CommunityArticleResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
            }
        })









        return binding.root

    }

    companion object {
        fun newInstance(): CommunityAllFragment {
            return CommunityAllFragment()
        }
    }

    inner class CommunityAllDetail(articleId:Int,title: String, text: String, heartCnt: Int) {
        var articleId:Int=0
        var title: String = ""
        var text: String = ""
        var hearCount: Int = 0

        init {
            this.articleId=articleId
            this.title = title
            this.text = text
            this.hearCount = hearCount
        }
    }


}