package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityLoginBinding
import com.UMCfront.religo.databinding.ActivityMenu1Binding
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient


// https://developers.kakao.com/console/app
class LoginActivity : AppCompatActivity() {
    // (참고) 카카오 소셜 로그인 -> 1. 카톡 [닉네임] , 2. 카카오계정 [이메일] 항목만 정보 수집하게 설정

    private lateinit var viewBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        /* 카카오 소셜 로그인 키 hash

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)

        [출력된 해시 값] IUREl7Vw6brX/5NbFsG722gkA74=

        */


        // 로그인 정보 확인하기
        UserApiClient.instance.accessTokenInfo { tokenInfo, error ->
            if (error != null) { // 토큰 정보 보기 오류
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            } else if (tokenInfo != null) { // 토큰 정보 가져오기 성공
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()

                // 로그인 성공 시 MenuActivity1로 이동
                val intent = Intent(this, MenuActivity1::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->

            if (error != null) {
                when {
                    error.toString() == AuthErrorCause.AccessDenied.toString() -> {
                        Toast.makeText(this, "접근이 거부 됨(동의 취소)", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidClient.toString() -> {
                        Toast.makeText(this, "유효하지 않은 앱", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidGrant.toString() -> {
                        Toast.makeText(this, "인증 수단이 유효하지 않아 인증할 수 없는 상태", Toast.LENGTH_SHORT)
                            .show()
                    }
                    error.toString() == AuthErrorCause.InvalidRequest.toString() -> {
                        Toast.makeText(this, "요청 파라미터 오류", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.InvalidScope.toString() -> {
                        Toast.makeText(this, "유효하지 않은 scope ID", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Misconfigured.toString() -> {
                        Toast.makeText(this, "설정이 올바르지 않음(android key hash)", Toast.LENGTH_SHORT)
                            .show()
                    }
                    error.toString() == AuthErrorCause.ServerError.toString() -> {
                        Toast.makeText(this, "서버 내부 에러", Toast.LENGTH_SHORT).show()
                    }
                    error.toString() == AuthErrorCause.Unauthorized.toString() -> {
                        Toast.makeText(this, "앱이 요청 권한이 없음", Toast.LENGTH_SHORT).show()
                    }
                    else -> { // Unknown
                        Toast.makeText(this, "기타 에러", Toast.LENGTH_SHORT).show()
                    }
                }
            } else if (token != null) {
                Toast.makeText(this, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, MenuActivity1::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }
        }

        // 카카오 소셜 로그인 이미지 버튼
        val kakao_login_btn = viewBinding.kakaoLoginBtn

        kakao_login_btn.setOnClickListener {
            if (LoginClient.instance.isKakaoTalkLoginAvailable(this)) {
                LoginClient.instance.loginWithKakaoTalk(this, callback = callback)
                // 카카오톡이 설치되어 있는 경우, 카카오톡으로 로그인
            } else {
                LoginClient.instance.loginWithKakaoAccount(this, callback = callback)
                // 카카오톡이 설치되어 있지 않는 경우, 카카오 계정으로 로그인
            }
        }

    }
}
