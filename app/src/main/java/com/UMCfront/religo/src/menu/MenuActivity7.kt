package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu6.*
import kotlinx.android.synthetic.main.activity_menu7.*

class MenuActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu7)

        menu7_next_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity8::class.java)
            startActivity(intent)
        }

        menu7_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity6::class.java)
            startActivity(intent)
        }
    }
}