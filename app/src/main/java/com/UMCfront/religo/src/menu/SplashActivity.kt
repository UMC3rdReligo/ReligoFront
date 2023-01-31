package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.UMCfront.religo.R

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        // 일정 시간 동안 splash 화면 띄우기
        Handler(Looper.getMainLooper()).postDelayed({
            // 일정 시간이 지나면 loginActivity로 이동
            val intent=Intent(this,LoginActivity::class.java)
            startActivity(intent)

            // 이전 키 눌렀을때 다시 splash 화면으로 이동하는 것을 방지하기 위해
            finish() // 이동 후 다시 사용한함
        }, 800) // 0.8초후 로그인 페이지로 이동
    }
}