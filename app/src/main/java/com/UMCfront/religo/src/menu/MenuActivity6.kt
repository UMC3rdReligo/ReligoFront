package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass.Companion.SPEditor
import kotlinx.android.synthetic.main.activity_menu6.*

class MenuActivity6 : AppCompatActivity() {
    val question_4 = "question_4"
    val question_5 = "question_5"
    // val preference by lazy {getSharedPreferences("MenuActivity6", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu6)

        applicationContext.getSharedPreferences("MenuActivity6", MODE_PRIVATE)

        // 다음으로 버튼
        menu6_next_btn.setOnClickListener {
            // question_4
            if (radio1_1.isChecked==true){
                SPEditor.putString(question_4, "0").apply()
            }
            else if(radio1_2.isChecked==true){
                SPEditor.putString(question_4, "1").apply()
            }
            else if(radio1_3.isChecked==true){
                SPEditor.putString(question_4, "2").apply()
            }
            else if(radio1_4.isChecked==true){
                SPEditor.putString(question_4, "3").apply()
            }
            else if(radio1_5.isChecked==true){
                SPEditor.putString(question_4, "4").apply()
            }

            // question_5
            if (radio2_1.isChecked==true){
                SPEditor.putString(question_5, "0").apply()
            }
            else if(radio2_2.isChecked==true){
                SPEditor.putString(question_5, "1").apply()
            }
            else if(radio2_3.isChecked==true){
                SPEditor.putString(question_5, "2").apply()
            }
            else if(radio2_4.isChecked==true){
                SPEditor.putString(question_5, "3").apply()
            }
            else if(radio2_5.isChecked==true){
                SPEditor.putString(question_5, "4").apply()
            }

            // 다음 페이지로 이동
            val intent = Intent(this, MenuActivity7::class.java)
            startActivity(intent)
        }
        // 이전으로 버튼
        menu6_back_btn.setOnClickListener {
            // 이전으로 돌아가면 현재 페이지에서 저장했던 shared preference 삭제
            val editor : SharedPreferences.Editor = SPEditor // 데이터 기록을 위한 editor
            editor.remove(question_4)
            editor.remove(question_5)
            editor.commit()

            val intent = Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }
    }
}