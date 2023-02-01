package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityMenu3Binding
import com.UMCfront.religo.databinding.ActivityMenu4Binding
import kotlinx.android.synthetic.main.activity_menu2.*
import kotlinx.android.synthetic.main.activity_menu4.*

class MenuActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu4)

        menu4_next_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity5::class.java)
            startActivity(intent)
        }

        menu4_back_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity3::class.java)
            startActivity(intent)
        }
    }
}