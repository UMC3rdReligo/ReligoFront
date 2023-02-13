package com.UMCfront.religo.src.main.church.data

import com.UMCfront.religo.src.main.church.data.model.ChurchSignup
import com.UMCfront.religo.src.main.church.data.model.ChurchtryResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface HometryRetrofitInterface {

    @POST("/churches/{churchId}/trials")
    fun sendUsertry(@Path("churchId") churchId:Int, @Body request: ChurchtryResult): Call<ChurchSignup>


}