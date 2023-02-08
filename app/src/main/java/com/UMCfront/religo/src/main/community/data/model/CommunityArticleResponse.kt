package com.UMCfront.religo.src.main.community.data

import com.UMCfront.religo.src.main.home.data.model.ChurchRecommendResult


public data class CommunityArticleResponse(

    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: List<CommunityArticleResult>
)



data class CommunityArticleResult(


    val articleId:Int,
    val writer:String,
    val type:String,
    val title:String,
    val heartCnt:Int,
    val text:String,
    val recently:Boolean

)
