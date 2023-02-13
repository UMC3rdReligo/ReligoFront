package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass.Companion.SPEditor
import kotlinx.android.synthetic.main.activity_menu3.*
import kotlinx.android.synthetic.main.activity_menu4.*

class MenuActivity4 : AppCompatActivity() {
    val question_3 = "question_3"
    // val preference by lazy {getSharedPreferences("MenuActivity4", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu4)

        applicationContext.getSharedPreferences("MenuActivity4", MODE_PRIVATE)

        // 다음으로 버튼
        menu4_next_btn.setOnClickListener {
            if (menu4_btn1.isSelected == true) {
                SPEditor.putString(question_3, "PA1").apply()
            } else if (menu4_btn2.isSelected == true) {
                SPEditor.putString(question_3, "PA2").apply()
            } else if (menu4_btn3.isSelected == true) {
                SPEditor.putString(question_3, "PA3").apply()
            } else if (menu4_btn4.isSelected == true) {
                SPEditor.putString(question_3, "PA4").apply()
            } else if (menu4_btn5.isSelected == true) {
                SPEditor.putString(question_3, "PA5").apply()
            } else if (menu4_btn6.isSelected == true) {
                SPEditor.putString(question_3, "PA6").apply()
            } else if (menu4_btn7.isSelected == true) {
                SPEditor.putString(question_3, "PA7").apply()
            } else if (menu4_btn8.isSelected == true) {
                SPEditor.putString(question_3, "PA8").apply()
            }

            // 다음 페이지로 이동
            val intent = Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }

        // 이전으로 버튼
        menu4_back_btn.setOnClickListener {
            // 이전으로 돌아가면 현재 페이지에서 저장했던 shared preference 삭제
            val editor : SharedPreferences.Editor = SPEditor // 데이터 기록을 위한 editor
            editor.remove(question_3)
            editor.commit()

            val intent = Intent(this, MenuActivity3::class.java)
            startActivity(intent)
        }


        menu4_btn1.setOnClickListener {
            menu4_btn1?.isSelected = menu4_btn1?.isSelected != true
            if (menu4_btn1.isSelected == true) {
                menu4_btn8?.isSelected = false
                menu4_btn2?.isSelected = false
                menu4_btn3?.isSelected = false
                menu4_btn4?.isSelected = false
                menu4_btn5?.isSelected = false
                menu4_btn6?.isSelected = false
                menu4_btn7?.isSelected = false
            }
        }
        menu4_btn2.setOnClickListener {
            menu4_btn2?.isSelected = menu4_btn2?.isSelected != true
            if (menu4_btn2.isSelected == true) {
                menu4_btn1?.isSelected = false
                menu4_btn8?.isSelected = false
                menu4_btn3?.isSelected = false
                menu4_btn4?.isSelected = false
                menu4_btn5?.isSelected = false
                menu4_btn6?.isSelected = false
                menu4_btn7?.isSelected = false
            }
        }
        menu4_btn3.setOnClickListener {
            menu4_btn3?.isSelected = menu4_btn3?.isSelected != true
            if (menu4_btn3.isSelected == true) {
                menu4_btn1?.isSelected = false
                menu4_btn2?.isSelected = false
                menu4_btn8?.isSelected = false
                menu4_btn4?.isSelected = false
                menu4_btn5?.isSelected = false
                menu4_btn6?.isSelected = false
                menu4_btn7?.isSelected = false
            }
        }
        menu4_btn4.setOnClickListener {
            menu4_btn4?.isSelected = menu4_btn4?.isSelected != true
            if (menu4_btn4.isSelected == true) {
                menu4_btn1?.isSelected = false
                menu4_btn2?.isSelected = false
                menu4_btn3?.isSelected = false
                menu4_btn8?.isSelected = false
                menu4_btn5?.isSelected = false
                menu4_btn6?.isSelected = false
                menu4_btn7?.isSelected = false
            }
        }
        menu4_btn5.setOnClickListener {
            menu4_btn5?.isSelected = menu4_btn5?.isSelected != true
            if (menu4_btn5.isSelected == true) {
                menu4_btn1?.isSelected = false
                menu4_btn2?.isSelected = false
                menu4_btn3?.isSelected = false
                menu4_btn4?.isSelected = false
                menu4_btn8?.isSelected = false
                menu4_btn6?.isSelected = false
                menu4_btn7?.isSelected = false
            }
        }
        menu4_btn6.setOnClickListener {
            menu4_btn6?.isSelected = menu4_btn6?.isSelected != true
            if (menu4_btn6.isSelected == true) {
                menu4_btn1?.isSelected = false
                menu4_btn2?.isSelected = false
                menu4_btn3?.isSelected = false
                menu4_btn4?.isSelected = false
                menu4_btn5?.isSelected = false
                menu4_btn8?.isSelected = false
                menu4_btn7?.isSelected = false
            }
        }
        menu4_btn7.setOnClickListener {
            menu4_btn7?.isSelected = menu4_btn7?.isSelected != true
            if (menu4_btn7.isSelected == true) {
                menu4_btn1?.isSelected = false
                menu4_btn2?.isSelected = false
                menu4_btn3?.isSelected = false
                menu4_btn4?.isSelected = false
                menu4_btn5?.isSelected = false
                menu4_btn6?.isSelected = false
                menu4_btn8?.isSelected = false
            }
        }
        menu4_btn8.setOnClickListener {
            menu4_btn8?.isSelected = menu4_btn8?.isSelected != true
            if (menu4_btn8.isSelected == true) {
                menu4_btn1?.isSelected = false
                menu4_btn2?.isSelected = false
                menu4_btn3?.isSelected = false
                menu4_btn4?.isSelected = false
                menu4_btn5?.isSelected = false
                menu4_btn6?.isSelected = false
                menu4_btn7?.isSelected = false
            }
        }
    }
}