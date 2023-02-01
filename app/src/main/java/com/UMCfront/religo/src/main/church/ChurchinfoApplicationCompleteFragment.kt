package com.UMCfront.religo.src.main.church

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R

class ChurchinfoApplicationCompleteFragment: Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_churchinfo_application_complete, container, false)
        return view

    }



        companion object {
        fun newInstance(): ChurchinfoApplicationCompleteFragment {
            return ChurchinfoApplicationCompleteFragment()
        }
    }


}