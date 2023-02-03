package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu4.*

class MenuActivity4 : AppCompatActivity() {

    val preference by lazy {getSharedPreferences("MenuActivity4", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu4)

        // 다음으로 버튼
        menu4_next_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }
        // 이전으로 버튼
        menu4_back_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity3::class.java)
            startActivity(intent)
        }

        // shared preference
        menu4_btn1.setOnClickListener {
            val question_3 = "#감리교"
            preference.edit().putString(question_3, "PA1").apply()
        }
        menu4_btn2.setOnClickListener {
            val question_3 = "#성결교"
            preference.edit().putString(question_3, "PA2").apply()
        }
        menu4_btn3.setOnClickListener {
            val question_3 = "#기독교 장로회"
            preference.edit().putString(question_3, "PA3").apply()
        }
        menu4_btn4.setOnClickListener {
            val question_3 = "#침례교"
            preference.edit().putString(question_3, "PA4").apply()
        }
        menu4_btn5.setOnClickListener {
            val question_3 = "#성공회"
            preference.edit().putString(question_3, "PA5").apply()
        }
        menu4_btn6.setOnClickListener {
            val question_3 = "#예수교 장로회"
            preference.edit().putString(question_3, "PA6").apply()
        }
        menu4_btn7.setOnClickListener {
            val question_3 = "#복음교회"
            preference.edit().putString(question_3, "PA7").apply()
        }
        menu4_btn8.setOnClickListener {
            val question_3 = "#상관없음"
            preference.edit().putString(question_3, "PA8").apply()
        }
    }
}