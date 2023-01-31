package com.UMCfront.religo.src.main.home.data

import retrofit2.Call
import retrofit2.http.GET

interface ChurchRecommendRetrofitInterface {
    @GET("/churches/recommend")
    fun getChurchRecommendation: Call<>
}