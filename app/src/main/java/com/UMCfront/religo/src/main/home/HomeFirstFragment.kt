package com.UMCfront.religo.src.main.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.CommunityChurchFragment

class HomeFirstFragment : Fragment() {

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_home, container, false)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val churchdetail2 = view.findViewById<ImageButton>(R.id.home_churchinfo2_findmore_imageButton)

        churchdetail2!!.setOnClickListener {

            (activity as MainActivity?)?.changeFragment(HomechurchinfoFragment())


        }
    }

}