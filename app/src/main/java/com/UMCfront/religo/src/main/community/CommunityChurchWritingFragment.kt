package com.UMCfront.religo.src.main.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.databinding.FragmentCommunityChurchWritingBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.data.CommunityArticleRetrofitInterface
import com.UMCfront.religo.src.main.community.data.model.CommunityArticlePostRequest
import com.UMCfront.religo.src.main.community.data.model.CommunityArticlePostResponse
import retrofit2.Call
import retrofit2.Response


class CommunityChurchWritingFragment : Fragment() {


    private var _binding: FragmentCommunityChurchWritingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCommunityChurchWritingBinding.inflate(inflater, container, false)



        val retrofit= ApplicationClass.sRetrofit
        val communityArticleService=retrofit.create(CommunityArticleRetrofitInterface::class.java)


        binding.cWritingComplete.setOnClickListener{
            val title=binding.communityTitleInput
            val text=binding.communityTextInput
            val info= CommunityArticlePostRequest("church",0,title.text.toString(),text.text.toString())

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

            (activity as MainActivity?)?.changeFragment(CommunityChurchFragment())
        }


        //뒤로가기 버튼 구현
        binding.communityChurchBack.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityChurchFragment.newInstance())
        }


            return binding.root
    }

    companion object {
        fun newInstance(): CommunityChurchWritingFragment {
            return CommunityChurchWritingFragment()
        }
    }
}