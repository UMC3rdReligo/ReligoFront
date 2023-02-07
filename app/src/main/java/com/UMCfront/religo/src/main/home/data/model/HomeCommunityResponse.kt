package com.UMCfront.religo.src.main.home.data.model

data class HomeCommunityResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<HomeCommunityAllList>
)

data class HomeCommunityAllList(


    val articleId:Int,
    val writer:String,
    val type:String,
    val title:String,
    val heartCnt:Int,
    val text:String,
    val recently:Boolean

)