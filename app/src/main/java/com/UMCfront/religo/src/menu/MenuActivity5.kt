package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu5.*

class MenuActivity5 : AppCompatActivity() {
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