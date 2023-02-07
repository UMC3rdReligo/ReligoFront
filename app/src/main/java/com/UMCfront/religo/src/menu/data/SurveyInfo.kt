package com.UMCfront.religo.src.menu.data

import android.provider.ContactsContract.CommonDataKinds.Nickname
import androidx.annotation.VisibleForTesting

// 보낼 값
data class SurveyInfo(
    var question_1: String,
    var address: String,
    // val locationCode: String,
    var question_2: String,
    var question_3: String,
    var hashTag: String,
    var question_4: String,
    var question_5: String,
    var question_6: String,
    var question_7: String,
    var question_8: String,
    var question_9: String,
    var nickname: String,
)

// 응답 값
data class SurveyResponse(
    var isSuccess: String,
    var code: Int,
    var message: String,
)
