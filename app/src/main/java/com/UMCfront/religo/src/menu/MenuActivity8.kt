package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu8.*

class MenuActivity8 : AppCompatActivity() {
    val question_8 = "question_8"
    val question_9 = "question_9"
    val preference by lazy {getSharedPreferences("MenuActivity8", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu8)

        // 다음으로 버튼
        menu8_next_btn.setOnClickListener {
            // question_8
            if (radio1_1.isChecked==true){
                preference.edit().putString(question_8, "0").apply()
            }
            else if(radio1_2.isChecked==true){
                preference.edit().putString(question_8, "1").apply()
            }
            else if(radio1_3.isChecked==true){
                preference.edit().putString(question_8, "2").apply()
            }
            else if(radio1_4.isChecked==true){
                preference.edit().putString(question_8, "3").apply()
            }
            else if(radio1_5.isChecked==true){
                preference.edit().putString(question_8, "4").apply()
            }

            // question_9
            if (radio2_1.isChecked==true){
                preference.edit().putString(question_9, "0").apply()
            }
            else if(radio2_2.isChecked==true){
                preference.edit().putString(question_9, "1").apply()
            }
            else if(radio2_3.isChecked==true){
                preference.edit().putString(question_9, "2").apply()
            }
            else if(radio2_4.isChecked==true){
                preference.edit().putString(question_9, "3").apply()
            }
            else if(radio2_5.isChecked==true){
                preference.edit().putString(question_9, "4").apply()
            }

            // 다음 페이지로 이동
            val intent = Intent(this, MenuActivity9::class.java)
            startActivity(intent)
        }
        // 이전으로 버튼
        menu8_back_btn.setOnClickListener {
            // 이전으로 돌아가면 현재 페이지에서 저장했던 shared preference 삭제
            val editor : SharedPreferences.Editor = preference.edit() // 데이터 기록을 위한 editor
            editor.remove(question_8)
            editor.remove(question_9)
            editor.commit()

            val intent = Intent(this, MenuActivity7::class.java)
            startActivity(intent)
        }
    }
}