package com.UMCfront.religo.src.main.church.data.model

import android.location.Address

data class ChurchSignup(

    val code : Int,
    val isSuccess: Boolean,
    val message: String,
    val result: ChurchSignupResult

)

data class ChurchSignupResult(
    val name: String,
    val birthday : String,
    val phoneNum: String,
    val address: String,
    val email: String,
    val referee: String,
    val message: String,
    val scheduledDate: String
)
