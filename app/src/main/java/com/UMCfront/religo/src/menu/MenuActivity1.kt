package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.core.widget.EdgeEffectCompat.create
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityMenu1Binding
import com.UMCfront.religo.src.menu.data.Menu1
import com.UMCfront.religo.src.menu.data.UserSurveyRetrofitService.Companion.Menu1create
import com.kakao.sdk.common.util.Utility
import kotlinx.android.synthetic.main.activity_menu1.*
import java.lang.ref.Cleaner.create

class MenuActivity1 : AppCompatActivity() {
    // 서버로 POST 보내기
    val binding by lazy { ActivityMenu1Binding.inflate(layoutInflater) }
    // val api = Menu1.Menu1create();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu1)

        menu1_next_btn.setOnClickListener {
            val intent=Intent(this, MenuActivity2::class.java)
            startActivity(intent)
        }

    }
}