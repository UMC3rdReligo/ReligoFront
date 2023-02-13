package com.UMCfront.religo.src.main.community.data

import com.UMCfront.religo.src.main.community.CommunityFragment

data class CommunityArticleDetailResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: CommunityArticleDetail
)

data class CommunityArticleDetail(
    val title:String,
    val text:String,
    val heartCnt:Int,
    val createdAt:String,
    val writer:String,
    val commentCnt:Int,
    val comments:List<Comments>
)

data class Comments(
    val name:String,
    val text:String,
    val createdAt: String
)
