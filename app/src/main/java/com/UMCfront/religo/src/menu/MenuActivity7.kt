package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu7.*

class MenuActivity7 : AppCompatActivity() {
    val preference by lazy {getSharedPreferences("MenuActivity7", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu7)

        // 다음으로 버튼
        menu7_next_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity8::class.java)
            startActivity(intent)
        }
        // 이전으로 버튼
        menu7_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity6::class.java)
            startActivity(intent)
        }

        // shared preference
        // "다른사람이나 집단에 관용적이다."
        radio1_1.setOnClickListener {
            val question_6 = "전혀아니다"
            preference.edit().putString(question_6, "0").apply()
        }
        radio1_2.setOnClickListener {
            val question_6 = "약간아니다"
            preference.edit().putString(question_6, "1").apply()
        }
        radio1_3.setOnClickListener {
            val question_6 = "보통이다"
            preference.edit().putString(question_6, "2").apply()
        }
        radio1_4.setOnClickListener {
            val question_6 = "약간그렇다"
            preference.edit().putString(question_6, "3").apply()
        }
        radio1_5.setOnClickListener {
            val question_6 = "매우그렇다"
            preference.edit().putString(question_6, "4").apply()
        }

        // "자신에게 엄격하고 ... ~"
        radio2_1.setOnClickListener {
            val question_7 = "전혀아니다"
            preference.edit().putString(question_7, "0").apply()
        }
        radio2_2.setOnClickListener {
            val question_7 = "약간아니다"
            preference.edit().putString(question_7, "1").apply()
        }
        radio2_3.setOnClickListener {
            val question_7 = "보통이다"
            preference.edit().putString(question_7, "2").apply()
        }
        radio2_4.setOnClickListener {
            val question_7 = "약간그렇다"
            preference.edit().putString(question_7, "3").apply()
        }
        radio2_5.setOnClickListener {
            val question_7 = "매우그렇다"
            preference.edit().putString(question_7, "4").apply()
        }
    }
}