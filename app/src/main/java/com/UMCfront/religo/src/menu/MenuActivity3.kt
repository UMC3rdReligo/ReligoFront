package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R

import kotlinx.android.synthetic.main.activity_menu1.*
import kotlinx.android.synthetic.main.activity_menu3.*

class MenuActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu3)

        menu3_back_btn.setOnClickListener{
            val intent = Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }

        menu3_next_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity4::class.java)
            startActivity(intent)
        }

    }
}