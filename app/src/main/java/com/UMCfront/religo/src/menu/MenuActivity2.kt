package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.databinding.ActivityMenu1Binding
import com.UMCfront.religo.databinding.ActivityMenu2Binding

class MenuActivity2 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMenu2Binding

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        viewBinding=ActivityMenu2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root);

        viewBinding.menu2BackBtn.setOnClickListener {
            val intent= Intent(this, MenuActivity1::class.java)
            startActivity(intent)
        }
    }
}