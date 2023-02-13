package com.UMCfront.religo.src.menu.retrofit

import com.UMCfront.religo.src.menu.data.SurveyInfo
import com.UMCfront.religo.src.menu.data.SurveyResponse
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface SignUp {
    @POST("/user/signup")
    @Headers("accept: application/json", "content-type: application/json")
    fun signup(
        @Body jsonparams: SurveyInfo
    ): Call<SurveyResponse>

    
    /* ApplicationClass에 작성된 전역변수 사용

    companion object{
        private const val BASE_URL = "https://jmlee.shop/"

        fun create(): SignUp {
            val gson: Gson = GsonBuilder().setLenient().create()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                // ↑ json을 gson 형태로 변환
                .build()
                .create(SignUp::class.java)
        }
    }

   */
}