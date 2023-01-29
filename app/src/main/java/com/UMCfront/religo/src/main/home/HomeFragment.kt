package com.UMCfront.religo.src.main.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import androidx.viewpager2.widget.ViewPager2
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.home.adapter.PagerFragmentStateAdapter


class HomeFragment : Fragment() {



    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val adapter = PagerFragmentStateAdapter(this)
        val fragments = listOf<Fragment>(HomeFirstFragment(),HomeSecondFragment(),HomeChurchsignupFragment())
        adapter.fragments.addAll(fragments)


        val view=inflater.inflate(R.layout.fragment_home, container, false)

        val viewPager2=view.findViewById<ViewPager2>(R.id.home_viewpager)

        viewPager2.adapter = adapter


        // Inflate the layout for this fragment
        return view

    }







    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}