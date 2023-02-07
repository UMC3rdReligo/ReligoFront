package com.UMCfront.religo.src.main.home.data.model

data class HomeUserInfoResponse (
        val code: Int,
        val isSuccess: Boolean,
        val message: String,
        val result: HomeUserInfo
)

data class HomeUserInfo(
        val name:String,
        val nickname:String,
        val address:String,
        val locationCode:String,
        val userAddress1:String,
        val userAddress2:String,
        val userAddress3:String,
        val churchId:Long,
        val churchName:String,
        val churchAddress:String
)