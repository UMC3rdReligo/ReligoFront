package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass.Companion.SPEditor
import kotlinx.android.synthetic.main.activity_menu1.*

class MenuActivity1 : AppCompatActivity() {
    /* 서버로 POST 보내기

    val binding by lazy { ActivityMenu1Binding.inflate(layoutInflater) }
    // val api = Menu1.Menu1create();

    */

    // shared preference 객체, Activity 초기화 이후에 사용해야 하기 때문에 lazy 위임
    // lazy: val인 경우에 사용 (호출 시점에서 최초 1회 초기화, 선언과 동시에 호출시점에서 초기화됨)
    val question_1 = "question_1"
    // val preference by lazy {getSharedPreferences("MenuActivity1", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu1)

        applicationContext.getSharedPreferences("MenuActivity1", MODE_PRIVATE)

        // 다음으로 버튼 클릭시 shared preference에 해당 question_1값 저장
        menu1_next_btn.setOnClickListener {
            if (menu1_btn1.isSelected==true){
                // question_1 키값으로 "최초 가입" 문자열 저장
                SPEditor.putString(question_1, menu1_btn1.text.toString()).apply()
            }
            else if(menu1_btn2.isSelected==true){
                // question_1 키값으로 "재가입" 문자열 저장
                SPEditor.putString(question_1, menu1_btn2.text.toString()).apply()
            }
            else if(menu1_btn3.isSelected==true){
                // question_1 키값으로 "친목형성" 문자열 저장
                SPEditor.putString(question_1, menu1_btn3.text.toString()).apply()
            }

            // 다음 페이지로 이동
            val intent = Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }

        // menu1_bin1 == "최초가입" 버튼을 클릭할 경우,
        menu1_btn1.setOnClickListener {
            menu1_btn1?.isSelected = menu1_btn1?.isSelected != true
            if (menu1_btn1.isSelected == true) {
                menu1_btn2?.isSelected = false
                menu1_btn3?.isSelected = false
            }
        }
        // menu1_bin2 == "재가입" 버튼을 클릭할 경우,
        menu1_btn2.setOnClickListener {
            menu1_btn2?.isSelected = menu1_btn2?.isSelected != true
            if(menu1_btn2.isSelected==true){
                menu1_btn1?.isSelected = false
                menu1_btn3?.isSelected = false
            }
        }
        // menu1_bin3 == "친목형성" 버튼을 클릭할 경우,
        menu1_btn3.setOnClickListener {
            menu1_btn3?.isSelected = menu1_btn3?.isSelected != true
            if (menu1_btn3.isSelected == true) {
                menu1_btn1?.isSelected = false
                menu1_btn2?.isSelected = false
            }
        }
    }
}