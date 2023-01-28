package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.FragmentCommunityAllArticleBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityCommentRVAdapter
import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter


class CommunityChurchArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCommunityAllArticleBinding.inflate(inflater, container, false)
        var communityChurchCommentList= mutableListOf<String>()
        communityChurchCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchCommentList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchCommentList.add("안녕하세요 이번에 새로 가입했습니다.")

        val communityCommentChurchAdapter= CommunityCommentRVAdapter(communityChurchCommentList)

        //community_grid_rv
        val rv=binding.communityCommentRv
        rv.adapter=communityCommentChurchAdapter
        rv.layoutManager= LinearLayoutManager(this.context)

        //뒤로가기
        binding.communityChurchBack.setOnClickListener{
            (activity as MainActivity?)?.changeFragment(CommunityFragment.newInstance())

        }

        return binding.root
    }

    companion object {
        fun newInstance(): CommunityChurchArticleFragment {
            return CommunityChurchArticleFragment()
        }
    }
}