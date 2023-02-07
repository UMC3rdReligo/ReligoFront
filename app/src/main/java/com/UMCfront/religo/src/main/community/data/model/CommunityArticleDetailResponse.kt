package com.UMCfront.religo.src.main.community.data

import com.UMCfront.religo.src.main.community.CommunityFragment

data class CommunityArticleDetailResponse(
    val code: Int,
    val isSuccess: Boolean,
    val message: String,
    val result: CommunityArticleDetail
)

data class CommunityArticleDetail(
    val title:String
)
