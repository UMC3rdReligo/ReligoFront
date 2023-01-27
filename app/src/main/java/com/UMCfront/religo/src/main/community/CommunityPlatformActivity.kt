package com.UMCfront.religo.src.main.community

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityCommunityAllBinding
import com.UMCfront.religo.databinding.ActivityCommunityPlatformBinding
import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter

class CommunityPlatformActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCommunityPlatformBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_community_platform)

        var communityPlatformList= mutableListOf<String>()
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityPlatformList.add("안녕하세요 이번에 새로 가입했습니다.")


        binding= ActivityCommunityPlatformBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val communityAdapter= CommunityGridAdapter(communityPlatformList)

        //community_grid_rv
        val rv=binding.communityGridRv
        rv.adapter=communityAdapter


        rv.layoutManager= GridLayoutManager(this,2)


    }
}