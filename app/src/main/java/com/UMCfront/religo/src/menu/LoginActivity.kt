package com.UMCfront.religo.src.menu

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.ActivityLoginBinding
import com.UMCfront.religo.databinding.ActivityMenu1Binding
import com.kakao.sdk.auth.LoginClient
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.common.model.AuthErrorCause
import com.kakao.sdk.common.util.Utility
import com.kakao.sdk.user.UserApiClient
import com.navercorp.nid.NaverIdLoginSDK
import com.navercorp.nid.oauth.NidOAuthLogin
import com.navercorp.nid.oauth.OAuthLoginCallback
import com.navercorp.nid.profile.NidProfileCallback
import com.navercorp.nid.profile.data.NidProfileResponse


// https://developers.kakao.com/console/app
class LoginActivity : AppCompatActivity() {
    // 카카오 소셜 로그인 -> 1. 카톡 [닉네임] , 2. 카카오계정 [이메일] 항목만 정보 수집하게 설정
    private lateinit var viewBinding: ActivityLoginBinding

    // 네이버 소셜 로그인
    // 1. [이름] 2. [닉네임] 3. [이메일] 항목만 정보 수집하게 설정
    private val TAG = this.javaClass.simpleName
    private var name: String=""
    private var email: String=""
    private var nickname: String=""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        /* 카카오 소셜 로그인 키 hash

        val keyHash = Utility.getKeyHash(this)
        Log.d("Hash", keyHash)

        [출력된 해시 값] IUREl7Vw6brX/5NbFsG722gkA74=

        */


        // [카톡] 로그인 정보 확인하기
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

        // [카톡] 소셜 로그인 이미지 버튼
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


        // [네이버] 소셜 로그인 구현
        val naverClientId= getString(R.string.naver_clinet_id)
        val naverClientSecret=getString(R.string.naver_client_secret)
        val naverClientName=getString(R.string.naver_client_name)
        NaverIdLoginSDK.initialize(this, naverClientId, naverClientSecret, naverClientName)

        viewBinding.naverLoginBtn.setOnClickListener {
            startNaverLogin()
        }
    }

    private fun startNaverLogin(){
        var naverToken: String? = ""

        var profileCallback=object :NidProfileCallback<NidProfileResponse>{
            override fun onSuccess(response: NidProfileResponse) {
                val userId = response.profile?.id
                Toast.makeText(this@LoginActivity, "로그인에 성공하였습니다.", Toast.LENGTH_SHORT).show()

                // 로그인 성공 시 이동
                val intent = Intent(this@LoginActivity, MenuActivity1::class.java)
                startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP))
                finish()
            }

            override fun onFailure(httpStatus: Int, message: String) {
                val errorCode=NaverIdLoginSDK.getLastErrorCode().code
                val errorDescription=NaverIdLoginSDK.getLastErrorDescription()
                Toast.makeText(this@LoginActivity,"errorCode: ${errorCode}\n"+
                        "errorDescription: ${errorDescription}",Toast.LENGTH_SHORT).show()
            }

            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }
        }

        val oauthLoginCallback= object :  OAuthLoginCallback{
            override fun onSuccess() {
                // 네이버 로그인 인증 성공시 실행
                naverToken=NaverIdLoginSDK.getAccessToken()

                // 로그인 유저 정보 불러오기
                NidOAuthLogin().callProfileApi(profileCallback)
            }

            override fun onFailure(httpStatus: Int, message: String) {
                val errorCode = NaverIdLoginSDK.getLastErrorCode().code
                val errorDescription = NaverIdLoginSDK.getLastErrorDescription()
                Toast.makeText(this@LoginActivity, "errorCode: ${errorCode}\n" +
                        "errorDescription: ${errorDescription}", Toast.LENGTH_SHORT).show()
            }

            override fun onError(errorCode: Int, message: String) {
                onFailure(errorCode, message)
            }
        }

        NaverIdLoginSDK.authenticate(this, oauthLoginCallback)
    }

    /*

    private fun setLayoutState(login:Boolean) {
        if (login) {
            viewBinding.naverLoginBtn.visibility = View.GONE
        } else {
            viewBinding.naverLoginBtn.visibility = View.VISIBLE
        }
    }

    */
}