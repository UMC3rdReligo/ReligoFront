package com.UMCfront.religo.src.survey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityUserSurvey3Binding

class UserSurveyActivity3 : AppCompatActivity() {
    private lateinit var viewBinging: ActivityUserSurvey3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_survey3)

        viewBinging= ActivityUserSurvey3Binding.inflate(layoutInflater)

        setContentView(viewBinging.root)

        viewBinging.btnNextUserSurvey3.setOnClickListener {
            val intent= Intent(this, UserSurveyActivity4::class.java)
            startActivity(intent)
        }
    }
}