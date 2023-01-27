package com.UMCfront.religo.src.main.community

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityCommunityAllBinding

import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter

class CommunityAllActivity : AppCompatActivity(){


    private lateinit var binding: ActivityCommunityAllBinding


    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_all)



        var communityAllList= mutableListOf<String>()
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")


        binding= ActivityCommunityAllBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val communityAdapter= CommunityGridAdapter(communityAllList)

        //community_grid_rv
        val rv=binding.communityGridRv
        rv.adapter=communityAdapter


        rv.layoutManager= GridLayoutManager(this,2)

        binding.communityFab.bringToFront()

        // 글쓰기 버튼 구현

        val fragment_community_writing=CommunityWritingFragment()
        binding.communityFab.setOnClickListener{
            Toast.makeText(applicationContext,"플로팅 클릭",Toast.LENGTH_LONG).show()
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.community_all,fragment_community_writing)
                .commit()
        }


    }


}