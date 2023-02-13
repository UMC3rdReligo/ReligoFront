package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.databinding.FragmentCommunityPlatformWritingBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.data.CommunityArticleRetrofitInterface
import com.UMCfront.religo.src.main.community.data.model.CommunityArticlePostRequest
import com.UMCfront.religo.src.main.community.data.model.CommunityArticlePostResponse
import retrofit2.Call
import retrofit2.Response


class CommunityPlatformWritingFragment : Fragment() {

    private var _binding: FragmentCommunityPlatformWritingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCommunityPlatformWritingBinding.inflate(inflater, container, false)

        val retrofit= ApplicationClass.sRetrofit
        val communityArticleService=retrofit.create(CommunityArticleRetrofitInterface::class.java)


        binding.cWritingComplete.setOnClickListener {
            binding.cWritingComplete.setOnClickListener{
                val title=binding.communityTitleInput
                val text=binding.communityTextInput
                val info= CommunityArticlePostRequest("PA1",1,title.text.toString(),text.text.toString())

                communityArticleService.postArticle(info).enqueue(object :retrofit2.Callback<CommunityArticlePostResponse>{


                    override fun onResponse(
                        call: Call<CommunityArticlePostResponse>,
                        response: Response<CommunityArticlePostResponse>
                    ) {
                        if (response.body() != null) {
                            Toast.makeText(context, response.body()!!.message.toString(), Toast.LENGTH_LONG).show()
                        }
                    }

                    override fun onFailure(call: Call<CommunityArticlePostResponse>, t: Throwable) {
                        Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
                    }


                })


            }
            (activity as MainActivity?)?.changeFragment(CommunityPlatformFragment())
        }

        //뒤로가기 버튼 구현
        binding.communityChurchBack.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityPlatformFragment.newInstance())
        }


            return binding.root


    }

    companion object {
        fun newInstance(): CommunityPlatformWritingFragment {
            return CommunityPlatformWritingFragment()
        }
    }
}