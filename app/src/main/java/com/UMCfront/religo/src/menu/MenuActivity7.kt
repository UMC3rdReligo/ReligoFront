package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu7.*

class MenuActivity7 : AppCompatActivity() {
    val question_6 = "question_6"
    val question_7 = "question_7"
    val preference by lazy {getSharedPreferences("MenuActivity7", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu7)

        // 다음으로 버튼
        menu7_next_btn.setOnClickListener {
            // question_6
            if (radio1_1.isChecked==true){
                preference.edit().putString(question_6, "0").apply()
            }
            else if(radio1_2.isChecked==true){
                preference.edit().putString(question_6, "1").apply()
            }
            else if(radio1_3.isChecked==true){
                preference.edit().putString(question_6, "2").apply()
            }
            else if(radio1_4.isChecked==true){
                preference.edit().putString(question_6, "3").apply()
            }
            else if(radio1_5.isChecked==true){
                preference.edit().putString(question_6, "4").apply()
            }

            // question_7
            if (radio2_1.isChecked==true){
                preference.edit().putString(question_7, "0").apply()
            }
            else if(radio2_2.isChecked==true){
                preference.edit().putString(question_7, "1").apply()
            }
            else if(radio2_3.isChecked==true){
                preference.edit().putString(question_7, "2").apply()
            }
            else if(radio2_4.isChecked==true){
                preference.edit().putString(question_7, "3").apply()
            }
            else if(radio2_5.isChecked==true){
                preference.edit().putString(question_7, "4").apply()
            }

            // 다음 페이지로 이동
            val intent = Intent(this, MenuActivity8::class.java)
            startActivity(intent)
        }

        // 이전으로 버튼
        menu7_back_btn.setOnClickListener {
            // 이전으로 돌아가면 현재 페이지에서 저장했던 shared preference 삭제
            val editor : SharedPreferences.Editor = preference.edit() // 데이터 기록을 위한 editor
            editor.remove(question_6)
            editor.remove(question_7)
            editor.commit()

            val intent = Intent(this, MenuActivity6::class.java)
            startActivity(intent)
        }
    }
}