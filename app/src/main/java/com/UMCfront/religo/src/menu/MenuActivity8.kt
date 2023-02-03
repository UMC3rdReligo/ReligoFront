package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu8.*

class MenuActivity8 : AppCompatActivity() {
    val preference by lazy {getSharedPreferences("MenuActivity8", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu8)

        // 다음으로 버튼
        menu8_next_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity9::class.java)
            startActivity(intent)
        }
        // 이전으로 버튼
        menu8_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity7::class.java)
            startActivity(intent)
        }

        // shared preference
        // "나는 다른사람의 행동에 대해서는 ... ~"
        radio1_1.setOnClickListener {
            val question_8 = "전혀아니다"
            preference.edit().putString(question_8, "0").apply()
        }
        radio1_2.setOnClickListener {
            val question_8 = "약간아니다"
            preference.edit().putString(question_8, "1").apply()
        }
        radio1_3.setOnClickListener {
            val question_8 = "보통이다"
            preference.edit().putString(question_8, "2").apply()
        }
        radio1_4.setOnClickListener {
            val question_8 = "약간그렇다"
            preference.edit().putString(question_8, "3").apply()
        }
        radio1_5.setOnClickListener {
            val question_8 = "매우그렇다"
            preference.edit().putString(question_8, "4").apply()
        }

        // "자신에게 엄격하고 ... ~"
        radio2_1.setOnClickListener {
            val question_9 = "전혀아니다"
            preference.edit().putString(question_9, "0").apply()
        }
        radio2_2.setOnClickListener {
            val question_9 = "약간아니다"
            preference.edit().putString(question_9, "1").apply()
        }
        radio2_3.setOnClickListener {
            val question_9 = "보통이다"
            preference.edit().putString(question_9, "2").apply()
        }
        radio2_4.setOnClickListener {
            val question_9 = "약간그렇다"
            preference.edit().putString(question_9, "3").apply()
        }
        radio2_5.setOnClickListener {
            val question_9 = "매우그렇다"
            preference.edit().putString(question_9, "4").apply()
        }
    }
}