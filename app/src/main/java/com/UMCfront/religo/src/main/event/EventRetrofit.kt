package com.UMCfront.religo.src.main.event

import retrofit2.Call
import retrofit2.http.GET

interface EventRetrofit {
    @GET("/events/bychurch")
    fun getEvent(): Call<EventResponse>
}