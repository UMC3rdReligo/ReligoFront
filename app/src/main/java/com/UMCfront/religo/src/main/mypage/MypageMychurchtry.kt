package com.UMCfront.religo.src.main.mypage

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R

class MypageMychurchtry : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_mypage_churchtry, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        Log.d("p101test","1")
        var MypageMychurchAdapter= mutableListOf<String>()
        MypageMychurchAdapter.add("church1")
        MypageMychurchAdapter.add("church2")
        MypageMychurchAdapter.add("church3")

        val mychurchsignup= view.findViewById<RecyclerView>(R.id.mypage_churchtry_recyclerview)
        val mychurchsignupAdapter= MypageMychurchAdapter(MypageMychurchAdapter)
        mychurchsignup.adapter=mychurchsignupAdapter
        mychurchsignup.layoutManager= LinearLayoutManager(this.context)
        Log.d("p101test","1011")

    }


}