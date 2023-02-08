package com.UMCfront.religo.src.main.home.data

import com.UMCfront.religo.src.main.home.data.model.HomeCommunityResponse
import com.UMCfront.religo.src.main.home.data.model.HomeUserInfoResponse
import retrofit2.Call
import retrofit2.http.GET

interface HomeUserInfoRetrofitInterface {

    @GET("/user/info")
    fun getHomeUserInfo(): Call<HomeUserInfoResponse>
}