package com.UMCfront.religo.src.main.church.data.model

import android.location.Address
import com.google.gson.annotations.SerializedName

data class ChurchSignup(

    val code : Int,
    val isSuccess: Boolean,
    val message: String,
    val result: String

)

data class ChurchSignupResult(
    @SerializedName("name") val name: String,
    @SerializedName("birthday")val birthday : String,
    @SerializedName("phoneNum")val phoneNum: String,
    @SerializedName("address")val address: String,
    @SerializedName("email")val email: String,
    @SerializedName("referee")val referee: String,
    @SerializedName("message")val message: String,
    @SerializedName("scheduleDate")val scheduledDate: String
)
