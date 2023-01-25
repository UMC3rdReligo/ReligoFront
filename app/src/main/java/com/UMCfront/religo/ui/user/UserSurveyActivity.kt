package com.UMCfront.religo.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityUserSurveyBinding

class UserSurveyActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityUserSurveyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_survey)

        viewBinding = ActivityUserSurveyBinding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.btnNextUserSurvey1.setOnClickListener {
            val intent= Intent(this, UserSurveyActivity2::class.java)
            startActivity(intent)
        }
    }
}