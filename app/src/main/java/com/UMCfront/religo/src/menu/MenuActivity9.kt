package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import kotlinx.android.synthetic.main.activity_menu8.*
import kotlinx.android.synthetic.main.activity_menu9.*

class MenuActivity9 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu9)

        menu9_next_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity10::class.java)
            startActivity(intent)
        }

        menu9_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity8::class.java)
            startActivity(intent)
        }
    }
}