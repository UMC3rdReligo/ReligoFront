package com.UMCfront.religo.src.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.FragmentHomeBinding
import com.UMCfront.religo.src.main.home.adapter.PagerFragmentStateAdapter


class HomeFragment : Fragment() {

    private var viewPager: ViewPager2? = null




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val pagerAdapter = PagerFragmentStateAdapter(requireActivity())
        // 3개의 Fragment Add
        pagerAdapter.addFragment(HomeFirstFragment())
        pagerAdapter.addFragment(HomeSecondFragment())
        // Adapter
        viewPager?.adapter = pagerAdapter

        viewPager?.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                Log.e("ViewPagerFragment", "Page ${position+1}")
            }
        })
    }





    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}