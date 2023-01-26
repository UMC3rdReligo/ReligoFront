package com.UMCfront.religo.src.main.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.FragmentHomeBinding
import com.UMCfront.religo.src.main.home.adapter.HomeFirstAdapter

class HomeActivity: AppCompatActivity(){
    private lateinit var binding: FragmentHomeBinding




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = FragmentHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewpagerHomeFragmentAdapter = HomeFirstAdapter(this)

        binding.homeviewpager2.adapter = viewpagerHomeFragmentAdapter


    }
}