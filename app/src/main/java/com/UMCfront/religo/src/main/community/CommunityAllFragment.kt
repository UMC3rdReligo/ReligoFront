package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
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




        val communityGridAdapter= CommunityGridAdapter(communityAllList)

        //community_grid_rv
        val rv=binding.communityGridRv
        rv.adapter=communityGridAdapter


        //linear layout으로 변경
        rv.layoutManager= LinearLayoutManager(this.context)

        binding.communityFab.bringToFront()

        // 글쓰기 버튼 구현
        binding.communityFab.setOnClickListener{

            Toast.makeText(context,"플로팅 클릭", Toast.LENGTH_LONG).show()

            (activity as MainActivity?)?.changeFragment(CommunityAllWritingFragment.newInstance())

        }


        // 글 클릭 구현
        communityGridAdapter.itemClick=object: CommunityGridAdapter.GridItemClick{
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
        fun newInstance(): CommunityAllFragment {
            return CommunityAllFragment()
        }
    }
}