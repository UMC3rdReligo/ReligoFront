package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.UMCfront.religo.databinding.FragmentCommunityChurchBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter


class CommunityChurchFragment : Fragment() {

    private var _binding: FragmentCommunityChurchBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var communityChurchList= mutableListOf<String>()
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")

        val binding = FragmentCommunityChurchBinding.inflate(inflater, container, false)


        val communityAdapter= CommunityGridAdapter(communityChurchList)

        //community_grid_rv
        val rv=binding.communityGridRv
        rv.adapter=communityAdapter


        rv.layoutManager= LinearLayoutManager(this.context)

        binding.communityFab.bringToFront()

        // 글쓰기 버튼 구현


        binding.communityFab.setOnClickListener{

            Toast.makeText(context,"플로팅 클릭", Toast.LENGTH_LONG).show()

            (activity as MainActivity?)?.changeFragment(CommunityChurchWritingFragment.newInstance())

        }
        // 글 클릭 구현
        communityAdapter.itemClick=object: CommunityGridAdapter.GridItemClick{
            override fun onClick(view: View, position: Int) {
                (activity as MainActivity?)?.changeFragment(CommunityChurchArticleFragment.newInstance())
            }

        }

        //뒤로가기 버튼 구현
        binding.communityChurchBack.setOnClickListener{
            (activity as MainActivity?)?.changeFragment(CommunityFragment.newInstance())

        }

        return binding.root

    }

    companion object {
        fun newInstance(): CommunityChurchFragment {
            return CommunityChurchFragment()
        }
    }
}