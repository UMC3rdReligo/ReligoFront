package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.databinding.FragmentCommunityChurchArticleBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityCommentRVAdapter


class CommunityChurchArticleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCommunityChurchArticleBinding.inflate(inflater, container, false)
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
            (activity as MainActivity?)?.changeFragment(CommunityChurchFragment.newInstance())

        }
        //댓글

        binding.communityCommentBtn.setOnClickListener{
            val text=binding.communityCommentInput
            Toast.makeText(context,text.text, Toast.LENGTH_LONG).show()
            communityChurchCommentList.add(text.text.toString())
            //리사이클러뷰 동적 추가
            communityCommentChurchAdapter.notifyItemInserted(communityChurchCommentList.size);
            text.text=null
        }

        return binding.root
    }

    companion object {
        fun newInstance(): CommunityChurchArticleFragment {
            return CommunityChurchArticleFragment()
        }
    }
}