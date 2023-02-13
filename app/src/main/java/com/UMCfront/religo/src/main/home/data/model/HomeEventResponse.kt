package com.UMCfront.religo.src.main.home.data.model

data class HomeEventResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: Infos
)

data class Infos(
    val infos:List<HomeEventInfos>
)

data class HomeEventInfos(

    val eventId:Int,
    val eventImage:List<String>,
    val eventName:String,
    val location:String,
    val eventDate:String,
    val eventIntroduction:String,
    val participation:String
)