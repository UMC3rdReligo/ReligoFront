package com.UMCfront.religo.src.main.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.UMCfront.religo.src.main.home.HomeActivity
import com.UMCfront.religo.src.main.home.HomeFirstFragment


class HomeFirstAdapter(fragmentHomeActivity: HomeActivity) :FragmentStateAdapter(fr)
{
    val fragmentList = listOf<Fragment>(HomeFirstFragment())

    // 2. ViesPager2에서 노출시킬 Fragment 의 갯수 설정
    fun getItemCount(): Int {
        return fragmentList.size
    }

    fun createFragment(position: Int): Fragment {
        return fragmentList[position]
    }

}