package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityMenu1Binding
import com.kakao.sdk.common.util.Utility

class MenuActivity1 : AppCompatActivity() {
    private lateinit var viewBinding : ActivityMenu1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityMenu1Binding.inflate(layoutInflater)
        setContentView(viewBinding.root);


        viewBinding.menu1Btn1.setOnClickListener {
            val intent= Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }
        viewBinding.menu1Btn2.setOnClickListener {
            val intent= Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }
        viewBinding.menu1Btn2.setOnClickListener {
            val intent= Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }
    }
}