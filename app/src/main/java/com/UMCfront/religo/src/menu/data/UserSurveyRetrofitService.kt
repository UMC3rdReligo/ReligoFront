package com.UMCfront.religo.src.menu.data

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


// 참고 사이트
// https://stickode.tistory.com/43

interface UserSurveyRetrofitService {
    @POST("/user/signup")
    @Headers("accept: application/json", "content-type: application/json")
    fun post_user(
        @Body jsonparms: Menu1
    ): Call<Menu1>


    // static 처럼 공유 객체로 사용 가능. (모든 인스턴스가 공유하는 객체로서 동작)
    companion object{
        private const val BASE_URL = ""

        fun Menu1create(): Menu1{

            val gson: Gson = GsonBuilder().setLenient().create();

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
                .create(Menu1::class.java)
        }
    }
}