package com.UMCfront.religo.src.main.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1

class HomeReviewAllFragment :Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_churchinfo_review_all, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var homereviewAllList= mutableListOf<String>()
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")


        val homerv= view.findViewById<RecyclerView>(R.id.churchinfo_review_RecyclerView)
        val homeReviewAdapter= CommunityRVAdapter1(homereviewAllList)



        homerv.adapter=homeReviewAdapter

//        homeReviewAdapter.itemClick=object:CommunityRVAdapter1.ItemClick{
//            override fun onClick(view: View, position: Int) {
//                (activity as MainActivity?)?.changeFragment(CommunityAllArticleFragment.newInstance())
//            }
//
//        }

        homerv.layoutManager= LinearLayoutManager(this.context)

    }


        companion object {
        fun newInstance(): HomeReviewAllFragment {
            return HomeReviewAllFragment()
        }
    }



}