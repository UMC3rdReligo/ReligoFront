package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.databinding.FragmentCommunityChurchArticleBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityAllCommentRVAdapter
import com.UMCfront.religo.src.main.community.adapter.CommunityChurchCommentRVAdapter
import com.UMCfront.religo.src.main.community.data.CommunityArticleDetailResponse
import com.UMCfront.religo.src.main.community.data.CommunityArticleDetailRetrofitService
import com.UMCfront.religo.src.main.community.data.model.CommunityCommentRequest
import com.UMCfront.religo.src.main.community.data.model.CommunityCommentResponse
import retrofit2.Call
import retrofit2.Response


class CommunityChurchArticleFragment : Fragment() {
    var communityChurchCommentList= mutableListOf<CommunityChurchArticleFragment.CommunityComment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val articleId=requireArguments().getInt("articleId")
        val retrofit= ApplicationClass.sRetrofit
        val communityDetailService=retrofit.create(CommunityArticleDetailRetrofitService::class.java)
        val binding = FragmentCommunityChurchArticleBinding.inflate(inflater, container, false)

        communityDetailService.getCommunityDetail(articleId).enqueue(object :retrofit2.Callback<CommunityArticleDetailResponse>{
            override fun onResponse(
                call: Call<CommunityArticleDetailResponse>,
                response: Response<CommunityArticleDetailResponse>
            ) {
                val res=response.body() as CommunityArticleDetailResponse
                val title=res.result.title
                val writer=res.result.writer
                val text=res.result.text
                val createdAt=res.result.createdAt
                val heartCnt=res.result.heartCnt
                val commentCnt=res.result.commentCnt
                val commentList=res.result.comments

                binding.communityChruchArticleTitle.text=title
                binding.communityChurchArticleText.text=text
                binding.communityChurchArticleWriter.text=writer
                binding.communityChurchArticleDate.text=createdAt
                binding.communityChurchArticleHeartCnt.text=heartCnt.toString()
                binding.communityChurchArticleCommentCnt.text=commentCnt.toString()

                for(item in commentList){
                    communityChurchCommentList.add(CommunityComment(item.name,item.text,item.createdAt))
                }

                val communityCommentChurchAdapter= CommunityChurchCommentRVAdapter(communityChurchCommentList)

                //community_grid_rv
                val rv=binding.communityCommentRv
                rv.adapter=communityCommentChurchAdapter
                rv.layoutManager=LinearLayoutManager(context)



                //댓글 입력 구현
                binding.communityCommentBtn.setOnClickListener{
                    val data=CommunityCommentRequest(articleId, binding.communityCommentInput.text.toString())

                    communityDetailService.postComment(data).enqueue(object :retrofit2.Callback<CommunityCommentResponse>{
                        override fun onResponse(
                            call: Call<CommunityCommentResponse>,
                            response: Response<CommunityCommentResponse>
                        ) {
                            val res=response.body() as CommunityCommentResponse
                        }

                        override fun onFailure(call: Call<CommunityCommentResponse>, t: Throwable) {
                            Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
                        }

                    })

                    Toast.makeText(context,binding.communityCommentInput.toString(),Toast.LENGTH_LONG).show()
                    binding.communityCommentInput.text=null
                }

                // 댓글 입력 반영

                communityDetailService.getCommunityDetail(articleId).enqueue(object :retrofit2.Callback<CommunityArticleDetailResponse>{
                    override fun onResponse(
                        call: Call<CommunityArticleDetailResponse>,
                        response: Response<CommunityArticleDetailResponse>
                    ) {
                        val commentList=res.result.comments
                        for(item in commentList){
                            communityChurchCommentList.add(CommunityComment(item.name,item.text,item.createdAt))
                        }

                        val communityCommentChurchAdapter= CommunityChurchCommentRVAdapter(communityChurchCommentList)

                        //community_grid_rv
                        val rv=binding.communityCommentRv
                        rv.adapter=communityCommentChurchAdapter
                        rv.layoutManager=LinearLayoutManager(context)
                    }

                    override fun onFailure(
                        call: Call<CommunityArticleDetailResponse>,
                        t: Throwable
                    ) {
                        Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
                    }

                })






            }

            override fun onFailure(call: Call<CommunityArticleDetailResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
            }
        })


        //뒤로가기
        binding.communityChurchBack.setOnClickListener{
            (activity as MainActivity?)?.changeFragment(CommunityChurchFragment.newInstance())

        }
        //댓글

        return binding.root
    }
    inner class CommunityComment constructor(name:String,text:String,date:String){
        var name=""
        var text=""
        var date=""

        init{
            this.name=name
            this.text=text
            this.date=date


        }
    }

    companion object {
        fun newInstance(): CommunityChurchArticleFragment {
            return CommunityChurchArticleFragment()
        }
    }
}