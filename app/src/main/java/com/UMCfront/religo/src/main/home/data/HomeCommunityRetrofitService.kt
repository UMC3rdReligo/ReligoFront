package com.UMCfront.religo.src.main.home.data

import com.UMCfront.religo.src.main.home.data.model.HomeCommunityResponse
import retrofit2.Call
import retrofit2.http.GET

interface HomeCommunityRetrofitService {

    @GET("/community/article/all")
    fun getHomeCommunityAll(): Call<HomeCommunityResponse>
}