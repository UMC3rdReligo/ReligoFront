package com.UMCfront.religo.src.main.community.data

import com.UMCfront.religo.src.main.community.data.model.CommunityUserInfoResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface CommunityArticleRetrofitInterface {

    @GET("/community/article/all")
    fun getCommunityAll(): Call<CommunityArticleResponse>

    @GET("/community/article/church/{churchId}")
    fun getCommunityChurch(@Path("churchId") churchId: Int):Call<CommunityArticleResponse>

    @GET("/community/article/platform/{platformcode}")
    fun getCommunityPlatform(@Path("platformcode") platformcode:String):Call<CommunityArticleResponse>

    @GET("/user/info")
    fun getUserInfo():Call<CommunityUserInfoResponse>





}