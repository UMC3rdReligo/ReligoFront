package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.databinding.FragmentCommunityAllArticleBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityCommentRVAdapter


class CommunityAllArticleFragment : Fragment() {

    private var _binding: FragmentCommunityAllArticleBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentCommunityAllArticleBinding.inflate(inflater, container, false)

        var communityAllCommentList= mutableListOf<String>()
        communityAllCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllCommentList.add("안녕하세요 이번에 새로 가입했습니다.")

        val communityCommentAllAdapter= CommunityCommentRVAdapter(communityAllCommentList)

        //community_grid_rv
        val rv=binding.communityCommentRv
        rv.adapter=communityCommentAllAdapter
        rv.layoutManager=LinearLayoutManager(this.context)



        //댓글 입력 구현
        binding.communityCommentBtn.setOnClickListener{
            val text=binding.communityCommentInput
            Toast.makeText(context,text.text,Toast.LENGTH_LONG).show()
            text.text=null
        }

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
}