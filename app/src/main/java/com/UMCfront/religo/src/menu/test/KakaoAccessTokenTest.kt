package com.UMCfront.religo.src.menu.test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.src.menu.MenuActivity1
import com.UMCfront.religo.src.menu.retrofit.KakaoLogin
import com.kakao.sdk.user.UserApiClient

// (joy/장은세) 카카오 소셜 로그인 accessToken 구현 테스트용 activity 입니다.

class KakaoAccessTokenTest : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        // 서버로 POST 하기 위한 코드
        val retrofit = ApplicationClass.sRetrofit
        val LoginService = retrofit.create(KakaoLogin::class.java)


        // 카카오 accessToken 값 가져오기에 성공하면 서버로 POST 날리기
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) {
                Toast.makeText(this, "토큰 정보 보기 실패", Toast.LENGTH_SHORT).show()
            } else if (tokenInfo != null) {
                Toast.makeText(this, "토큰 정보 보기 성공", Toast.LENGTH_SHORT).show()



                // (서버로 accesstoken을 Post 할 코드 작성 예정)



                val intent = Intent(this, MenuActivity1::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }
    }
}