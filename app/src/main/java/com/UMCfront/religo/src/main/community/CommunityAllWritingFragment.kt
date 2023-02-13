package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.databinding.FragmentCommunityAllWritingBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityAllCommentRVAdapter
import com.UMCfront.religo.src.main.community.data.CommunityArticleDetailResponse
import com.UMCfront.religo.src.main.community.data.CommunityArticleRetrofitInterface
import com.UMCfront.religo.src.main.community.data.model.CommunityArticlePostRequest
import com.UMCfront.religo.src.main.community.data.model.CommunityArticlePostResponse
import retrofit2.Call
import retrofit2.Response


class CommunityAllWritingFragment : Fragment() {


    private var _binding: FragmentCommunityAllWritingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentCommunityAllWritingBinding.inflate(inflater, container, false)

        val retrofit= ApplicationClass.sRetrofit
        val communityArticleService=retrofit.create(CommunityArticleRetrofitInterface::class.java)
        binding.cWritingComplete.setOnClickListener {
            val title=binding.communityAllTitleInput
            val text=binding.communityAllTextInput
            val info=CommunityArticlePostRequest("total",0,title.text.toString(),text.text.toString())

            communityArticleService.postArticle(info).enqueue(object :retrofit2.Callback<CommunityArticlePostResponse>{


                override fun onResponse(
                    call: Call<CommunityArticlePostResponse>,
                    response: Response<CommunityArticlePostResponse>
                ) {
                    if (response.body() != null) {
                        Toast.makeText(context, response.body()!!.message.toString(),Toast.LENGTH_LONG).show()
                    }
                }

                override fun onFailure(call: Call<CommunityArticlePostResponse>, t: Throwable) {
                    Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
                }


            })

            (activity as MainActivity?)?.changeFragment(CommunityAllFragment())
        }

        //뒤로가기 버튼 구현
        binding.communityChurchBack.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityAllFragment.newInstance())
        }

            return binding.root
    }

    companion object {
        fun newInstance(): CommunityAllWritingFragment {
            return CommunityAllWritingFragment()
        }
    }
}