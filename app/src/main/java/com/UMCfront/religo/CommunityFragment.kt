package com.UMCfront.religo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup


class CommunityFragment : Fragment() {
    //dddddwq


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false)
    }

    companion object {
        // fragment 인스턴스 사용하기 위해 companion object 사용
        fun newInstance():CommunityFragment{
            return CommunityFragment()
        }
    }
}