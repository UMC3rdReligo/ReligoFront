package com.UMCfront.religo.src.main.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter

class CommunityChurchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_church)

        var communityChurchList= mutableListOf<String>()
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityChurchList.add("안녕하세요 이번에 새로 가입했습니다.")




        val communityAdapter= CommunityGridAdapter(communityChurchList)

        val rv=findViewById<RecyclerView>(R.id.community_grid_rv)
        rv.adapter=communityAdapter


        rv.layoutManager= GridLayoutManager(this,2)
    }
}