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
import com.UMCfront.religo.databinding.FragmentCommunityAllArticleBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityAllCommentRVAdapter
import com.UMCfront.religo.src.main.community.data.CommunityArticleDetailResponse
import com.UMCfront.religo.src.main.community.data.CommunityArticleDetailRetrofitService
import com.UMCfront.religo.src.main.community.data.model.CommunityCommentRequest
import com.UMCfront.religo.src.main.community.data.model.CommunityCommentResponse
import retrofit2.Call
import retrofit2.Response


class CommunityAllArticleFragment : Fragment() {

    private var _binding: FragmentCommunityAllArticleBinding? = null


    var communityAllCommentList= mutableListOf<CommunityComment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val retrofit= ApplicationClass.sRetrofit
        val communityDetailService=retrofit.create(CommunityArticleDetailRetrofitService::class.java)

        val binding = FragmentCommunityAllArticleBinding.inflate(inflater, container, false)

        val articleId=requireArguments().getInt("articleId")

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

                binding.communityAllArticleTitle.text=title.toString()
                binding.communityAllArticleText.text=text.toString()
                binding.communityAllArticleWriter.text=writer
                binding.communityAllArticleCreated.text=createdAt
                binding.communityAllArticleHeartCnt.text=heartCnt.toString()
                binding.communityAllArticleCommentCnt.text=commentCnt.toString()

                for(item in commentList){
                    communityAllCommentList.add(CommunityComment(item.name,item.text,item.createdAt))
                }

                val communityCommentAllAdapter= CommunityAllCommentRVAdapter(communityAllCommentList)

                //community_grid_rv
                val rv=binding.communityCommentRv
                rv.adapter=communityCommentAllAdapter
                rv.layoutManager=LinearLayoutManager(context)



                //댓글 입력 구현
                binding.communityCommentBtn.setOnClickListener{

                    val data=CommunityCommentRequest(articleId,binding.communityCommentInput.text.toString())

                    communityDetailService.postComment(data).enqueue(object :retrofit2.Callback<CommunityCommentResponse>{
                        override fun onResponse(
                            call: Call<CommunityCommentResponse>,
                            response: Response<CommunityCommentResponse>
                        ) {
                            Log.d("cc11111",data.text.toString())

                            if (response.body() != null) {
                                Toast.makeText(context, response.body()!!.message.toString(),Toast.LENGTH_LONG).show()
                            }
                            //Toast.makeText(context,binding.communityCommentInput.text,Toast.LENGTH_LONG).show()
                            binding.communityCommentInput.text=null


                        }

                        override fun onFailure(call: Call<CommunityCommentResponse>, t: Throwable) {
                            Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
                        }

                    })


                }

                // 댓글 입력 반영

                communityDetailService.getCommunityDetail(articleId).enqueue(object :retrofit2.Callback<CommunityArticleDetailResponse>{
                    override fun onResponse(
                        call: Call<CommunityArticleDetailResponse>,
                        response: Response<CommunityArticleDetailResponse>
                    ) {
                        val commentList=res.result.comments
                        for(item in commentList){
                            communityAllCommentList.add(CommunityComment(item.name,item.text,item.createdAt))
                        }

                        val communityCommentAllAdapter= CommunityAllCommentRVAdapter(communityAllCommentList)

                        //community_grid_rv
                        val rv=binding.communityCommentRv
                        rv.adapter=communityCommentAllAdapter
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






        //뒤로 가기

        //뒤로가기 버튼 구현
        binding.communityChurchBack.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityAllFragment.newInstance())
        }


        return binding.root
    }



    companion object {
        fun newInstance(): CommunityAllArticleFragment {
            return CommunityAllArticleFragment()
        }
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


}