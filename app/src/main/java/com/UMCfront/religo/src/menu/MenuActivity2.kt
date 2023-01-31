package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import kotlinx.android.synthetic.main.activity_menu1.*
import kotlinx.android.synthetic.main.activity_menu2.*

class MenuActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu2)

        menu2_next_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity3::class.java)
            startActivity(intent)
        }

        menu2_back_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity1::class.java)
            startActivity(intent)
        }

    }
}