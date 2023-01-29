package com.UMCfront.religo.src.main.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.UMCfront.religo.databinding.FragmentCommunityChurchWritingBinding
import com.UMCfront.religo.src.main.MainActivity


class CommunityChurchWritingFragment : Fragment() {


    private var _binding: FragmentCommunityChurchWritingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCommunityChurchWritingBinding.inflate(inflater, container, false)

        val title=binding.communityTitleInput
        val text=binding.communityTextInput



        binding.cWritingComplete.setOnClickListener{
            Toast.makeText(context,title.text,Toast.LENGTH_LONG).show()
            // 백엔드 통신
            Log.d("writing222",title.text.toString())
            (activity as MainActivity?)?.changeFragment(CommunityChurchFragment())
        }

        //뒤로가기 버튼 구현
        binding.communityChurchBack.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityChurchFragment.newInstance())
        }


            return binding.root
    }

    companion object {
        fun newInstance(): CommunityChurchWritingFragment {
            return CommunityChurchWritingFragment()
        }
    }
}