package com.UMCfront.religo.src.main.mypage

import retrofit2.Call
import retrofit2.http.GET

interface MypageChurchResponseService {
    @GET("/churches/registrations/me/latest")
    fun getMypageChurchSignup () : Call<MypageChurchResopnse>
}