package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu5.*

class MenuActivity5 : AppCompatActivity() {

    // (2/2 작성) menue 5 layout 버튼을 checkBox로 변경 후 shared preference 구현 예정
    // 2/3(금) 중으로 변경후 다시 pr 보내겠습니다!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu5)

        menu5_next_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity6::class.java)
            startActivity(intent)
        }

        menu5_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity4::class.java)
            startActivity(intent)
        }
    }
}