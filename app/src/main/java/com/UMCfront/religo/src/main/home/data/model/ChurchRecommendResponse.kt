package com.UMCfront.religo.src.main.home.data.model

import com.UMCfront.religo.src.main.home.HomeFragment

public data class ChurchRecommendResponse(

    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<ChurchRecommendResult>
)

data class ChurchRecommendResult(
    val info:InfoResult,
    val hashtags:List<String>,
    val mainImage:String,
    val detailImage:List<String>

)

data class InfoResult(
    val id:Int,
    val info:PlatformList,
    val location:LocationList,
    val name:String,
    val address:String,
    val homepage:String,
    val introduction:String,
    val minister:String,
    val schedule:String,
    val phoneNUm:String
)



data class PlatformList(
    val code:String,
    val name:String,
    val groupCode:String
)

data class LocationList(
    val code:String,
    val address1:String,
    val address2:String,
    val address3:String,
    val countryCode :String,
    val cityCode:String

)


