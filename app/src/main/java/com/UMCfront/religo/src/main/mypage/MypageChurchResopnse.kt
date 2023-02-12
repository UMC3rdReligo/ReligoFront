package com.UMCfront.religo.src.main.mypage

import com.UMCfront.religo.src.main.church.data.model.ChurchDetailResult

data class MypageChurchResopnse(


    val isSuccess: Boolean,
    val code: Int,
    val message: String,
    val result: MypageChurchRegister

)

data class MypageChurchRegister(

    val id: Int,
    val userId: Int,
    val churchId: Int,
    val name: String,
    val birthday : String,
    val phoneNum: String,
    val address: String,
    val email : String,
    val referee: String,
    val message: String,
    val scheduledDateTime: String,
    val createdAt : String

)

