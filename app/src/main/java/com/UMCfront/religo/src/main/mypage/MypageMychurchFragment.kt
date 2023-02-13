package com.UMCfront.religo.src.main.mypage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.src.main.church.data.ChurchDetailRetrofitService
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

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
        mypagerAdapter.addFragment(MypageMychurchtry())
        mypagerAdapter.addFragment(MypageMychurchsignup())
        mypagerAdapter.addFragment(MypageMychurchsigned())
        mychurch_viewpager.adapter = mypagerAdapter

        TabLayoutMediator(view.findViewById<TabLayout>(R.id.tl_navigation_view),mychurch_viewpager) { tab, position ->
            Log.e("p101test", "ViewPager position: ${position}")
            when (position) {
                0 -> tab.text = "1회 체험"
                1 -> tab.text = "승인 대기"
                2 -> tab.text = "가입한 교회"
            }
        }.attach()

    }

    companion object {
        fun newInstance(): MypageMychurchFragment {
            return MypageMychurchFragment()
        }
    }

}