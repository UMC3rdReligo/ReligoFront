package com.UMCfront.religo.src.menu.data

import android.provider.ContactsContract.CommonDataKinds.Nickname
import androidx.annotation.VisibleForTesting

public data class Menu1(
    val question_1: String
)

data class Menu2(
    val question_2: String
)

data class Menu3(
    val address : String,
    val locationCode : Int,
)

data class Menu4(
    val question_3: String,
)

data class Menu5(
    val hashTag : List<String>
)

data class Menu6(
    val question_4: String,
    val question_5: String
)

data class Menu7(
    val question_6: String,
    val question_7: String
)

data class Menu8(
    val question_8: String,
    val question_9: String
)

data class Menu9(
    val nickname: String
)