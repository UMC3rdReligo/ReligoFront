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
<<<<<<< HEAD

        builder.addHeader("Authorization", "Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOm51bGwsInJvbGUiOiJST0xFX1VTRVIiLCJpZCI6NDUsImV4cCI6MTY3NjA2MTU5M30.tdytaDdyngijC0rMqGohCsgZZWOVSMpYuLGzd0vw-DM")

        builder.addHeader("Authorization","Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJqdWxpZTA5NjQ0QG5hdmVyLmNvbSIsInJvbGUiOiJST0xFX1VTRVIiLCJpZCI6MjcsImV4cCI6MTY3NTM1MTI4NX0.ZUSyKidVvRFhmBKEdTE_SPoeKZAATnK9SXi2m_xq2jo")
=======
        builder.addHeader("Authorization","Bearer "+"eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhaW1rMTIubmF2ZXIuY29tIiwicm9sZSI6IlJPTEVfVVNFUiIsImlkIjoxNSwiZXhwIjoxNjc2MjkzOTA2fQ.xkfQOnprV_gWDi78NKMF06Ug7toBsFu1G1Wwfac7eJM")
>>>>>>> afd70730f43892d096cf9d118aeaa15738e0a10d

        builder.addHeader("Authorization", "Bearer" + "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOm51bGwsInJvbGUiOiJST0xFX1VTRVIiLCJpZCI6NDUsImV4cCI6MTY3NjA2MTU3OH0.KNsF_hJLbrqsdrsO4-1WGLY0-b6fAaLUNcm-1hcpAMU")

        return chain.proceed(builder.build())
    }
}