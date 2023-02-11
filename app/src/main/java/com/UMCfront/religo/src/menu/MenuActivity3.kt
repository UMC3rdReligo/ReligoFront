package com.UMCfront.religo.src.menu

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass.Companion.SPEditor
import kotlinx.android.synthetic.main.activity_menu3.*

class MenuActivity3 : AppCompatActivity() {
    val question_2 = "question_2"
    // val preference by lazy {getSharedPreferences("MenuActivity3", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu3)

        applicationContext.getSharedPreferences("MenuActivity3", MODE_PRIVATE)

        // 이전으로 버튼
        menu3_back_btn.setOnClickListener{
            // 이전으로 돌아갈때 현재 페이지에서 저장했던 shared preference 삭제하기
            // 근데 어처피 버튼 다시 선택하면 shared preference값 변경돼서 굳이 삭제할 필요는 없는둣
            // 그래도 혹시 모를 메모리 절약을 위해 삭제하도록 하겠음!
            val editor : SharedPreferences.Editor = SPEditor // 데이터 기록을 위한 editor
            editor.remove(question_2)
            editor.commit()

            val intent = Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }
        // 다음으로 버튼
        menu3_next_btn.setOnClickListener {
            if (menu3_btn1.isSelected==true){
                SPEditor.putString(question_2, menu3_btn1.text.toString()).apply()
            }
            else if(menu3_btn2.isSelected==true){
                SPEditor.putString(question_2, menu3_btn2.text.toString()).apply()
            }
            else if(menu3_btn3.isSelected==true){
                SPEditor.putString(question_2, menu3_btn3.text.toString()).apply()
            }
            else if(menu3_btn4.isSelected==true){
                SPEditor.putString(question_2, menu3_btn4.text.toString()).apply()
            }

            // 다음 페이지로 이동
            val intent = Intent(this, MenuActivity4::class.java)
            startActivity(intent)
        }


        menu3_btn1.setOnClickListener {
            menu3_btn1?.isSelected = menu3_btn1?.isSelected != true
            if (menu3_btn1.isSelected == true) {
                menu3_btn2?.isSelected = false
                menu3_btn3?.isSelected = false
                menu3_btn4?.isSelected = false
            }
        }
        menu3_btn2.setOnClickListener {
            menu3_btn2?.isSelected = menu3_btn2?.isSelected != true
            if(menu3_btn2.isSelected==true){
                menu3_btn1?.isSelected = false
                menu3_btn3?.isSelected = false
                menu3_btn4?.isSelected = false
            }
        }
        menu3_btn3.setOnClickListener {
            menu3_btn3?.isSelected = menu3_btn3?.isSelected != true
            if (menu3_btn3.isSelected == true) {
                menu3_btn1?.isSelected = false
                menu3_btn2?.isSelected = false
                menu3_btn4?.isSelected = false
            }
        }
        menu3_btn4.setOnClickListener {
            menu3_btn4?.isSelected = menu3_btn4?.isSelected != true
            if (menu3_btn3.isSelected == true) {
                menu3_btn1?.isSelected = false
                menu3_btn2?.isSelected = false
                menu3_btn3?.isSelected = false
            }
        }
    }
}