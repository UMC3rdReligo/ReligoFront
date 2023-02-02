package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu3.*

class MenuActivity3 : AppCompatActivity() {

    val preference by lazy {getSharedPreferences("MenuActivity3", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu3)

        // 이전으로 버튼
        menu3_back_btn.setOnClickListener{
            val intent = Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }
        // 다음으로 버튼
        menu3_next_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity4::class.java)
            startActivity(intent)
        }

        // shared preference
        menu3_btn1.setOnClickListener {
            val question_2 = "모태신앙"
            preference.edit().putString(question_2, menu3_btn1.text.toString()).apply()
        }
        menu3_btn2.setOnClickListener {
            val question_2 = "주변인의 권유"
            preference.edit().putString(question_2, menu3_btn2.text.toString()).apply()
        }
        menu3_btn3.setOnClickListener {
            val question_2 = "마음의 안정"
            preference.edit().putString(question_2, menu3_btn3.text.toString()).apply()
        }
        menu3_btn4.setOnClickListener {
            val question_2 = "가입한 적 없음"
            preference.edit().putString(question_2, menu3_btn4.text.toString()).apply()
        }
    }
}