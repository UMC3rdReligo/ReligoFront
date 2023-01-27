package com.UMCfront.religo.src.main.community

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.FragmentCommunityAllBinding
import com.UMCfront.religo.databinding.FragmentCommunityWritingBinding


class CommunityWritingFragment : Fragment() {


    private var _binding: FragmentCommunityWritingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentCommunityWritingBinding.inflate(inflater, container, false)

        val title=binding.communityTitleInput
        val text=binding.communityTextInput



        binding.cWritingComplete.setOnClickListener{
            Toast.makeText(context,title.text,Toast.LENGTH_LONG).show()
            // 백엔드 통신
            Log.d("writing222",title.text.toString())
        }


        return binding.root
    }

    companion object {
        fun newInstance(): CommunityWritingFragment {
            return CommunityWritingFragment()
        }
    }
}