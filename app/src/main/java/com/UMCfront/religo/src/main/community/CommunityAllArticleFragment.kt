package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.FragmentCommunityAllArticleBinding
import com.UMCfront.religo.databinding.FragmentCommunityAllWritingBinding
import com.UMCfront.religo.src.main.community.adapter.CommunityCommentRVAdapter
import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter


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



        return binding.root
    }

    companion object {
        fun newInstance(): CommunityAllArticleFragment {
            return CommunityAllArticleFragment()
        }
    }
}