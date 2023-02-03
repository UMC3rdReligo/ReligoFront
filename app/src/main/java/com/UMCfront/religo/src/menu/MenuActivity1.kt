package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu1.*

class MenuActivity1 : AppCompatActivity() {
    /* 서버로 POST 보내기

    val binding by lazy { ActivityMenu1Binding.inflate(layoutInflater) }
    // val api = Menu1.Menu1create();

    */

    // shared preference 객체, Activity 초기화 이후에 사용해야 하기 때문에 lazy 위임
    // lazy: val인 경우에 사용 (호출 시점에서 최초 1회 초기화, 선언과 동시에 호출시점에서 초기화됨)
    val preference by lazy {getSharedPreferences("MenuActivity1", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu1)

        menu1_next_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }

        // menu1_bin1 == "최초가입" 버튼을 클릭할 경우,
        menu1_btn1.setOnClickListener {
            val question_1 = "최초 가입"
            // question_1 키값으로 "최초 가입" 문자열 저장
            preference.edit().putString(question_1, menu1_btn1.text.toString()).apply()
        }

        // menu1_bin2 == "재가입" 버튼을 클릭할 경우,
        menu1_btn2.setOnClickListener {
            val question_1 = "재가입"
            // question_1 키값으로 "재가입" 문자열 저장
            preference.edit().putString(question_1, menu1_btn2.text.toString()).apply()
        }

        // menu1_bin3 == "친목형성" 버튼을 클릭할 경우,
        menu1_btn3.setOnClickListener {
            val question_1 = "친목형성"
            // question_1 키값으로 "친목형성" 문자열 저장
            preference.edit().putString(question_1, menu1_btn3.text.toString()).apply()
        }
    }
}