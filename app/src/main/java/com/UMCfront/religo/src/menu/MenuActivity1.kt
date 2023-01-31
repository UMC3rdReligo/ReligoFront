package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.UMCfront.religo.R
import com.kakao.sdk.common.util.Utility
import kotlinx.android.synthetic.main.activity_menu1.*

class MenuActivity1 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu1)

        menu1_next_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }

    }
}