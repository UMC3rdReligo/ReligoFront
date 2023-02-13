package com.UMCfront.religo.src.main.home.data

import com.UMCfront.religo.src.main.home.data.model.HomeEventResponse
import retrofit2.Call
import retrofit2.http.GET

interface HomeEventRetrofitService {
    @GET("/events/all")
    fun getHomeEvent(): Call<HomeEventResponse>
}