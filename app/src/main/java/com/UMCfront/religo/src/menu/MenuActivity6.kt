package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu6.*

class MenuActivity6 : AppCompatActivity() {

    val preference by lazy {getSharedPreferences("MenuActivity6", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu6)

        // 다음으로 버튼
        menu6_next_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity7::class.java)
            startActivity(intent)
        }
        // 이전으로 버튼
        menu6_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }

        // shared preference
        // "매사에 긍정적인 편이다."
        radio1_1.setOnClickListener {
            val question_4 = "전혀아니다"
            preference.edit().putString(question_4, "0").apply()
        }
        radio1_2.setOnClickListener {
            val question_4 = "약간아니다"
            preference.edit().putString(question_4, "1").apply()
        }
        radio1_3.setOnClickListener {
            val question_4 = "보통이다"
            preference.edit().putString(question_4, "2").apply()
        }
        radio1_4.setOnClickListener {
            val question_4 = "약간그렇다"
            preference.edit().putString(question_4, "3").apply()
        }
        radio1_5.setOnClickListener {
            val question_4 = "매우그렇다"
            preference.edit().putString(question_4, "4").apply()
        }

        // "새로운 일에 도전하는 것을 좋아한다."
        radio2_1.setOnClickListener {
            val question_5 = "전혀아니다"
            preference.edit().putString(question_5, "0").apply()
        }
        radio2_2.setOnClickListener {
            val question_5 = "약간아니다"
            preference.edit().putString(question_5, "1").apply()
        }
        radio2_3.setOnClickListener {
            val question_5 = "보통이다"
            preference.edit().putString(question_5, "2").apply()
        }
        radio2_4.setOnClickListener {
            val question_5 = "약간그렇다"
            preference.edit().putString(question_5, "3").apply()
        }
        radio2_5.setOnClickListener {
            val question_5 = "매우그렇다"
            preference.edit().putString(question_5, "4").apply()
        }
    }
}