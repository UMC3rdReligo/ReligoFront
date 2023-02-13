package com.UMCfront.religo.src.main.community.data.model

import com.google.gson.annotations.SerializedName

data class CommunityArticlePostRequest(

    @SerializedName("type") val type:String="",
    @SerializedName("churchId") val churchId: Int=0,
    @SerializedName("text") val text: String=""
)
