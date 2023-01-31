package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu7.*
import kotlinx.android.synthetic.main.activity_menu8.*

class MenuActivity8 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu6)

        menu8_next_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity9::class.java)
            startActivity(intent)
        }

        menu8_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity7::class.java)
            startActivity(intent)
        }
    }
}