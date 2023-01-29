package com.UMCfront.religo.src.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.CommunityChurchFragment

class HomechurchinfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_churchinfo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val churchtry = view.findViewById<Button>(R.id.home_churchtry_button)
        val churchsignup = view.findViewById<Button>(R.id.home_churchsignup_button)

        churchtry!!.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(HomeChurchtryFragment())
        }

        churchsignup!!.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(HomeChurchsignupFragment())
        }



    }

}