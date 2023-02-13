package com.UMCfront.religo.src.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R

class MypageChurchtryFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_mypage_churchtry, container, false)
        return view
    }

    companion object {
        fun newInstance(): MypageChurchtryFragment {
            return MypageChurchtryFragment()
        }
    }

}