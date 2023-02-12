package com.UMCfront.religo.src.main.mypage

import com.UMCfront.religo.src.main.church.data.model.ChurchDetailResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MypageChurchtryResposeRetrofitInterface {
    @GET("/churches/trials/me")
    fun getMypageChurchtry () : Call<MypageChurchtryResopnse>

}