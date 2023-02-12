package com.UMCfront.religo.config
import okhttp3.Interceptor
import okhttp3.Request
import okhttp3.Response
import java.io.IOException
// 서버 jwt 유저 식별, 자동으로 http통신이 나갈 때 해더에 sp에 저장된 jwt값을 붙여줌
class AccessTokenInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val builder: Request.Builder = chain.request().newBuilder()
//        val jwtToken: String? = loginSharedPreferences.getString(X_ACCESS_TOKEN, null)
//        if (jwtToken != null) {
//
//        }
        builder.addHeader("Authorization","Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOm51bGwsInJvbGUiOiJST0xFX1VTRVIiLCJpZCI6NDYsImV4cCI6MTY3NjI0NjYyMn0.6LeS83wTKfmdXv8ZSy_1b_cjWi5dqsLQuBT1oPBHsXs")

        return chain.proceed(builder.build())
    }
}