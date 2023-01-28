package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.FragmentCommunityAllBinding
import com.UMCfront.religo.databinding.FragmentCommunityChurchBinding
import com.UMCfront.religo.databinding.FragmentCommunityPlatformBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1


class CommunityPlatformFragment : Fragment() {
    private var _binding: FragmentCommunityPlatformBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var communityPlatformList= mutableListOf<String>()
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")


        val binding = FragmentCommunityPlatformBinding.inflate(inflater, container, false)

        val communityAdapter= CommunityGridAdapter(communityPlatformList)

        //community_grid_rv
        val rv=binding.communityGridRv
        rv.adapter=communityAdapter


        rv.layoutManager= LinearLayoutManager(this.context)

        binding.communityFab.bringToFront()

        // 글쓰기 버튼 구현


        binding.communityFab.setOnClickListener{

            Toast.makeText(context,"플로팅 클릭", Toast.LENGTH_LONG).show()

            (activity as MainActivity?)?.changeFragment(CommunityPlatformWritingFragment())

        }

        // 글 클릭 구현
        communityAdapter.itemClick=object: CommunityGridAdapter.GridItemClick{
            override fun onClick(view: View, position: Int) {
                (activity as MainActivity?)?.changeFragment(CommunityAllArticleFragment.newInstance())
            }

        }

        //뒤로가기 버튼 구현
        binding.communityChurchBack.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityFragment.newInstance())
        }

            return binding.root
    }

    companion object {
        fun newInstance(): CommunityPlatformFragment {
            return CommunityPlatformFragment()
        }
    }
}