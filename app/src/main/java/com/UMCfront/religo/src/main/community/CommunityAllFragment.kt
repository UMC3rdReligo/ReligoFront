package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityCommunityAllBinding
import com.UMCfront.religo.databinding.FragmentCommunityAllBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter


class CommunityAllFragment : Fragment() {
    private var _binding: FragmentCommunityAllBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val binding = FragmentCommunityAllBinding.inflate(inflater, container, false)

        var communityAllList= mutableListOf<String>()
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")




        val communityAdapter= CommunityGridAdapter(communityAllList)

        //community_grid_rv
        val rv=binding.communityGridRv
        rv.adapter=communityAdapter


        rv.layoutManager= GridLayoutManager(context,2)

        binding.communityFab.bringToFront()

        // 글쓰기 버튼 구현

        val fragment_community_writing=CommunityWritingFragment()
        binding.communityFab.setOnClickListener{

            Toast.makeText(context,"플로팅 클릭", Toast.LENGTH_LONG).show()

            (activity as MainActivity?)?.changeFragment(CommunityWritingFragment())

        }

        return binding.root

    }

    companion object {
        fun newInstance(): CommunityAllFragment {
            return CommunityAllFragment()
        }
    }
}