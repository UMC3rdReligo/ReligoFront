package com.UMCfront.religo.src.main.mypage

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter


class MypageMychurchPagerAdapter(fa: MypageMychurchFragment) : FragmentStateAdapter(fa) {

    val fragments = mutableListOf<Fragment>()

    override fun getItemCount(): Int {
        return fragments.size
    }
    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }

    fun addFragment(fa: Fragment){
        fragments.add(fa)
        notifyItemInserted(fragments.size - 1)
    }

    fun removeFragment(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }


}