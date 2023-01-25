package com.UMCfront.religo.ui.user

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityUserSurvey5Binding

class UserSurveyActivity5 : AppCompatActivity() {
    private lateinit var viewBinding: ActivityUserSurvey5Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_survey5)

        viewBinding= ActivityUserSurvey5Binding.inflate(layoutInflater)

        setContentView(viewBinding.root)

        viewBinding.btnNextUserSurvey5.setOnClickListener {
            val intent = Intent(this, UserSurveyActivity6::class.java)
            startActivity(intent)
        }
    }
}