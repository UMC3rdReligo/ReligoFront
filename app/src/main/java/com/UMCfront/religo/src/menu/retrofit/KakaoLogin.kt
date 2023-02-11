package com.UMCfront.religo.src.menu.retrofit

import com.UMCfront.religo.src.menu.data.KaKaoAccessToken
import com.UMCfront.religo.src.menu.data.KakaoResponse

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.Headers
import retrofit2.http.POST

interface KakaoLogin {
    @POST("/user/login")
    // @Headers("accept: application/json", "content-type: application/json")
    fun login(
        @Header("Authorization") authorization : KaKaoAccessToken // 헤더로 accessToken 보내야 함
        // @Body jsonparams: KaKaoAccessToken
    ): Call<KakaoResponse>
}