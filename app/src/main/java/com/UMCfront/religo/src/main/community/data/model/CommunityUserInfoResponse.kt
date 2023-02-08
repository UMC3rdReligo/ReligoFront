package com.UMCfront.religo.src.main.community.data.model

data class CommunityUserInfoResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: UserInfo
)

data class UserInfo(
    val name:String,
    val churchId:Long,
    val churchName:String,
    val churchAddress:String

)
