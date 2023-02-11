package com.UMCfront.religo.src.main.church.data

import com.UMCfront.religo.src.main.church.data.model.ChurchSignup
import com.UMCfront.religo.src.main.church.data.model.ChurchSignupResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface HomeSignupRetorfitInterface {

    @POST("/churches/{churchId}/registrations")
    fun sendUserSignup(@Path("churchId") churchId:Int, @Body request: ChurchSignupResult): Call<ChurchSignup>

}