package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import kotlinx.android.synthetic.main.activity_menu8.*
import kotlinx.android.synthetic.main.activity_menu9.*

class MenuActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu6)

        menu9_next_btn.setOnClickListener {
            // 일정 시간 동안 welcome 화면 띄우기
            Handler(Looper.getMainLooper()).postDelayed({
                // 일정 시간이 지나면 MainActivity로 이동
                val intent=Intent(this,MainActivity::class.java)
                startActivity(intent)

                // 이전 키 눌렀을때 다시 splash 화면으로 이동하는 것을 방지하기 위해
                finish() // 이동 후 다시 사용 안함
            }, 3000) // 3초후 mainActivity로 이동
        }

        menu9_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity8::class.java)
            startActivity(intent)
        }
    }
}