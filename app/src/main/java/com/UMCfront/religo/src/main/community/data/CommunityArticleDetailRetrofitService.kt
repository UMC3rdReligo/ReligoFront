package com.UMCfront.religo.src.main.community.data


import com.UMCfront.religo.src.main.community.CommunityChurchArticleFragment
import com.UMCfront.religo.src.main.community.data.model.CommunityCommentRequest
import com.UMCfront.religo.src.main.community.data.model.CommunityCommentResponse
import retrofit2.Call
import retrofit2.http.*

interface CommunityArticleDetailRetrofitService{


    @GET("/community/article/{articleId}")
    fun getCommunityDetail(@Path("articleId") articleId: Int): Call<CommunityArticleDetailResponse>

    @POST("/community/article/comment")
    fun postComment(@Body comment:CommunityCommentRequest):Call<CommunityCommentResponse>







}
