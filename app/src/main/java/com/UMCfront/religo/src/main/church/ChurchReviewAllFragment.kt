package com.UMCfront.religo.src.main.church

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.church.adapter.ChurchDetailAdapter
import com.UMCfront.religo.src.main.church.adapter.ChurchDetailGridAdapter
import com.UMCfront.religo.src.main.community.CommunityAllArticleFragment
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1

class ChurchReviewAllFragment :Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_churchinfo_review_all, container, false)

        var homereviewAllList= mutableListOf<String>()
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")


        val homerv= view.findViewById<RecyclerView>(R.id.home_review_rv)
        val homeReviewAdapter= ChurchDetailGridAdapter(homereviewAllList)



        homerv.adapter=homeReviewAdapter


        homerv.layoutManager= LinearLayoutManager(this.context)

        return view

    }




        companion object {
        fun newInstance(): ChurchReviewAllFragment {
            return ChurchReviewAllFragment()
        }
    }



}