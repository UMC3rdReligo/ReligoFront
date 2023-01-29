package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.databinding.ActivityMenu3Binding
import com.UMCfront.religo.databinding.ActivityMenu4Binding

class MenuActivity4 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMenu4Binding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewBinding= ActivityMenu4Binding.inflate(layoutInflater)
        setContentView(viewBinding.root);


        // 선택지 버튼
        // ★★★ (추후 수정예정) 반복문 사용해서 코드 길이 줄이기
        viewBinding.menu4Btn1.setOnClickListener {
            val intent= Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }
        viewBinding.menu4Btn2.setOnClickListener {
            val intent= Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }
        viewBinding.menu4Btn3.setOnClickListener {
            val intent= Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }
        viewBinding.menu4Btn4.setOnClickListener {
            val intent= Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }
        viewBinding.menu4Btn5.setOnClickListener {
            val intent= Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }
        viewBinding.menu4Btn6.setOnClickListener {
            val intent= Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }
        viewBinding.menu4Btn7.setOnClickListener {
            val intent= Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }
        viewBinding.menu4Btn8.setOnClickListener {
            val intent= Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }


        // 이전으로 버튼
        viewBinding.menu4BackBtn.setOnClickListener {
            val intent= Intent(this, MenuActivity3::class.java)
            startActivity(intent)
        }
    }
}