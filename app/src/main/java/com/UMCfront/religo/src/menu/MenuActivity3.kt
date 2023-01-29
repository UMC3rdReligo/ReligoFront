package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.databinding.ActivityMenu2Binding
import com.UMCfront.religo.databinding.ActivityMenu3Binding

class MenuActivity3 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMenu3Binding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewBinding= ActivityMenu3Binding.inflate(layoutInflater)
        setContentView(viewBinding.root);


        // 선택지 버튼
        viewBinding.menu2Btn1.setOnClickListener {
            val intent= Intent(this, MenuActivity4::class.java)
            startActivity(intent)
        }
        viewBinding.menu2Btn2.setOnClickListener {
            val intent= Intent(this, MenuActivity4::class.java)
            startActivity(intent)
        }
        viewBinding.menu2Btn3.setOnClickListener {
            val intent= Intent(this, MenuActivity4::class.java)
            startActivity(intent)
        }
        viewBinding.menu2Btn4.setOnClickListener {
            val intent= Intent(this, MenuActivity4::class.java)
            startActivity(intent)
        }


        // 이전으로 버튼
        viewBinding.menu3BackBtn.setOnClickListener {
            val intent= Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }
    }
}