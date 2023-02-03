package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity

class MenuActivity10 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu10)

        Handler(Looper.getMainLooper()).postDelayed({
            // 일정 시간이 지나면 MainActivity로 이동
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)

            // 이전 키 눌렀을때 다시 splash 화면으로 이동하는 것을 방지하기 위해
            finish() // 이동 후 다시 사용 안함
        }, 1500) // 1.5초후 mainActivity로 이동
    }
}