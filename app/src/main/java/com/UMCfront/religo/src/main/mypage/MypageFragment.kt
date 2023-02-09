package com.UMCfront.religo.src.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.church.ChurchinfoWriteFragment

class MypageFragment: Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_mypage, container, false)
        return view



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mychurchbtn = view.findViewById<LinearLayout>(R.id.mypage_mychurch_block)


    }

    companion object {
        fun newInstance(): MypageFragment {
            return MypageFragment()
        }
    }

}