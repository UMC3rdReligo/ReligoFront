package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import kotlinx.android.synthetic.main.activity_menu3.*
import kotlinx.android.synthetic.main.activity_menu8.*
import kotlinx.android.synthetic.main.activity_menu9.*

class MenuActivity9 : AppCompatActivity() {
    val nickname = "nickname"
    val preference by lazy {getSharedPreferences("MenuActivity9", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu9)

        // 이전으로 버튼
        menu9_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity8::class.java)
            startActivity(intent)
        }

        // shared preference
        // ★★★ menu 1~9에서 shared preference에 저장해둔 값 서버로 POST 하기
        join_btn.setOnClickListener {
            preference.edit().putString(nickname, nickNameField.text.toString()).apply()

            val intent = Intent(this, MenuActivity10::class.java)
            startActivity(intent)
        }
    }
}