package com.UMCfront.religo.src.main.church.data

import com.UMCfront.religo.src.main.church.data.model.ChurchSignup
import com.UMCfront.religo.src.main.church.data.model.ChurchSignupResult
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface HomeSignupRetorfitInterface {

    @POST("/churches/{churchId}/registrations")
    fun sendUserSignup(@Body ChurchSignup: ChurchSignupResult): Call<ChurchSignup>

}