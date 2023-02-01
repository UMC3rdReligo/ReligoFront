package com.UMCfront.religo.src.main.home.data

import com.UMCfront.religo.src.main.home.data.model.ChurchRecommendResponse
import retrofit2.Call
import retrofit2.http.GET

interface ChurchRecommendRetrofitService {
    @GET("/churches/recommend")
    fun getChurchRecommendation(): Call<ChurchRecommendResponse>

}