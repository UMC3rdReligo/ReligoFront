package com.UMCfront.religo.src.menu.data


// 보낼 값
data class KaKaoAccessToken(
    val kakaoAccesstoken: String
)


// Response
data class KakaoResponse(
    val inSuccess: String,
    val code: Int,
    val message: String,
    val result: List<KakaoResponseResult>
)

data class KakaoResponseResult(
    val accesstoken: String,
    val refresToken: String,
    val signYN: String,
)