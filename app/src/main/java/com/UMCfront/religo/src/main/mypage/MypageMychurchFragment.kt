package com.UMCfront.religo.src.main.mypage

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.UMCfront.religo.R

class MypageMychurchFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_mypage_mychurch, container, false)
        return view



    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mychurch_viewpager = view.findViewById<ViewPager2>(R.id.mypage_mychurch_viewpager)
        val mypagerAdapter = MypageMychurchPagerAdapter(this)
        mypagerAdapter.addFragment(MypageFragment())
        mypagerAdapter.addFragment(MypageFragment())
        mypagerAdapter.addFragment(MypageFragment())

        mychurch_viewpager.adapter = mypagerAdapter

    }

    companion object {
        fun newInstance(): MypageMychurchFragment {
            return MypageMychurchFragment()
        }
    }

}