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

    // 공유 객체로 사용 가능 (static과 유사) -> 모든 인스턴스가 공유하는 객체로서 동작함
    companion object{
        private const val BASE_URL = "(서버 주소)" // 서버 주소

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
}