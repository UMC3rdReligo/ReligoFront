package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.databinding.ActivityLoginBinding
import com.UMCfront.religo.src.menu.data.KaKaoAccessToken
import com.UMCfront.religo.src.menu.data.KakaoResponse
import com.UMCfront.religo.src.menu.retrofit.KakaoLogin
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.ClientError
import com.kakao.sdk.common.model.ClientErrorCause
import com.kakao.sdk.user.UserApiClient


// https://developers.kakao.com/console/app
class LoginActivity : AppCompatActivity() {
    private var _binding: ActivityLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /* KakaoSDK 초기화 -> ApplicationClass에서 수행
        KakaoSdk.init(this, this.getString(R.string.kakao_app_key))
         */

        /** Click_listener */
        binding.kakaoLoginBtn.setOnClickListener {
            kakaoLogin() //로그인
        }
    }

    private fun kakaoLogin() {
        // 카카오계정으로 로그인 공통 callback 구성
        // 카카오톡으로 로그인 할 수 없어 카카오계정으로 로그인할 경우 사용됨
        val callback: (OAuthToken?, Throwable?) -> Unit = { token, error ->
            if (error != null) {
                Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()
            } else if (token != null) {
                //TODO: 최종적으로 카카오로그인 및 유저정보 가져온 결과
                UserApiClient.instance.me { user, error ->
                    Toast.makeText(this, "실행 1 : 로그인 성공", Toast.LENGTH_SHORT).show()

                    // 서버로 POST할 변수 설정
                    val retrofit = ApplicationClass.sRetrofit
                    val LoginService = retrofit.create(KakaoLogin::class.java)

                    // 카카오로부터 받은 accessToken 값 변수에 저장
                    val accessToken = KaKaoAccessToken(token.accessToken.toString())
                    // val refreshToken = KaKaoAccessToken(token.refreshToken.toString())
                    // 토큰값 확인
                    Log.d("accessToken 값: ", token.accessToken.toString())
                    
                    LoginService.login(accessToken).enqueue(object : retrofit2.Callback<KakaoResponse> {
                        override fun onResponse(
                            call: retrofit2.Call<KakaoResponse>,
                            response: retrofit2.Response<KakaoResponse>
                        ) {
                            Log.d("response", response.toString())
                            Log.d("header", response.headers().toString())
                        }

                        override fun onFailure(call: retrofit2.Call<KakaoResponse>, t: Throwable) {
                            // 실패
                            Log.d("response", t.message.toString())
                            Log.d("response", "fail")
                        }
                    })
                    
                    val intent= Intent(this, LoadingActivity::class.java)
                    startActivity(intent)
                    
                }
            }
        }

        // 카카오톡이 설치되어 있으면 카카오톡으로 로그인, 아니면 카카오계정으로 로그인
        if (UserApiClient.instance.isKakaoTalkLoginAvailable(this)) {
            UserApiClient.instance.loginWithKakaoTalk(this) { token, error ->
                if (error != null) {
                    Toast.makeText(this, "로그인 실패", Toast.LENGTH_SHORT).show()

                    // 사용자가 카카오톡 설치 후 디바이스 권한 요청 화면에서 로그인을 취소한 경우,
                    // 의도적인 로그인 취소로 보고 카카오계정으로 로그인 시도 없이 로그인 취소로 처리 (예: 뒤로 가기)
                    if (error is ClientError && error.reason == ClientErrorCause.Cancelled) {
                        return@loginWithKakaoTalk
                    }

                    // 카카오톡에 연결된 카카오계정이 없는 경우, 카카오계정으로 로그인 시도
                    UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
                } else if (token != null) {
                    Toast.makeText(this, "실행 2: 로그인 성공", Toast.LENGTH_SHORT).show()

                    // 서버로 POST할 변수 설정
                    val retrofit = ApplicationClass.sRetrofit
                    val LoginService = retrofit.create(KakaoLogin::class.java)

                    // 카카오로부터 받은 accessToken 값 변수에 저장
                    val accessToken = KaKaoAccessToken(token.accessToken.toString())
                    // val refreshToken = KaKaoAccessToken(token.refreshToken.toString())
                    // 토큰값 확인
                    Log.d("accessToken 값: ", token.accessToken.toString())

                    LoginService.login(accessToken).enqueue(object : retrofit2.Callback<KakaoResponse> {
                        override fun onResponse(
                            call: retrofit2.Call<KakaoResponse>,
                            response: retrofit2.Response<KakaoResponse>
                        ) {
                            Log.d("response", response.toString())
                            Log.d("header", response.headers().toString())
                        }

                        override fun onFailure(call: retrofit2.Call<KakaoResponse>, t: Throwable) {
                            // 실패
                            Log.d("response", t.message.toString())
                            Log.d("response", "fail")
                        }
                    })

                    val intent= Intent(this, LoadingActivity::class.java)
                    startActivity(intent)
                }
            }
        } else {
            UserApiClient.instance.loginWithKakaoAccount(this, callback = callback)
        }
    }
}