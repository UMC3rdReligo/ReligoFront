package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.UMCfront.religo.databinding.FragmentCommunityAllWritingBinding
import com.UMCfront.religo.src.main.MainActivity


class CommunityAllWritingFragment : Fragment() {


    private var _binding: FragmentCommunityAllWritingBinding? = null
    private val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        val binding = FragmentCommunityAllWritingBinding.inflate(inflater, container, false)

        binding.cWritingComplete.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityAllFragment())
        }

        //뒤로가기 버튼 구현
        binding.communityChurchBack.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityAllFragment.newInstance())
        }

            return binding.root
    }

    companion object {
        fun newInstance(): CommunityAllWritingFragment {
            return CommunityAllWritingFragment()
        }
    }
}