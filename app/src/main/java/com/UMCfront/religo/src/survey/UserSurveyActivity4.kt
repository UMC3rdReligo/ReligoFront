package com.UMCfront.religo.src.survey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityUserSurvey4Binding

class UserSurveyActivity4 : AppCompatActivity() {
    private lateinit var viewBinging: ActivityUserSurvey4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_survey4)

        viewBinging = ActivityUserSurvey4Binding.inflate(layoutInflater)

        setContentView(viewBinging.root)

        viewBinging.btnNextUserSurvey4.setOnClickListener {
            val intent = Intent(this, UserSurveyActivity5::class.java)
            startActivity(intent)
        }

    }
}