package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.UMCfront.religo.databinding.FragmentCommunityPlatformWritingBinding
import com.UMCfront.religo.src.main.MainActivity


class CommunityPlatformWritingFragment : Fragment() {

    private var _binding: FragmentCommunityPlatformWritingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentCommunityPlatformWritingBinding.inflate(inflater, container, false)

        val title=binding.communityTitleInput
        val text=binding.communityTextInput

        binding.cWritingComplete.setOnClickListener {
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