package com.UMCfront.religo.src.main.community.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class CommunityCommentRequest(
    @SerializedName("articleId") val articleId: Int=0,
    @SerializedName("text") val text: String=""
)