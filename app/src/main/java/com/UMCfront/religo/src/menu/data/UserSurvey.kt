package com.UMCfront.religo.src.menu.data

import android.provider.ContactsContract.CommonDataKinds.Nickname
import com.UMCfront.religo.src.main.home.data.model.ChurchRecommendResult

data class UserSurvey(
    val address : String,
    val hashTag : List<String>,
    val locationCode : Int,
    val nickname: String,
    val question_1: String,
    val question_2: String,
    val question_3: String,
    val question_4: String,
    val question_5: String,
    val question_6: String,
    val question_7: String,
    val question_8: String,
    val question_9: String,
)