package com.UMCfront.religo.src.main.church.data

import com.UMCfront.religo.src.main.church.data.model.ChurchDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ChurchDetailRetrofitService {
    @GET("/churches/{churchId}")
    fun getChurchDetail(@Path("churchId") churchId:Int): Call<ChurchDetailResponse>
}