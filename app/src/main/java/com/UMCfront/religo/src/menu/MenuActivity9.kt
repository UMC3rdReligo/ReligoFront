package com.UMCfront.religo.src.menu

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.config.ApplicationClass.Companion.SPEditor
import com.UMCfront.religo.config.ApplicationClass.Companion.getString
import com.UMCfront.religo.src.menu.data.SurveyInfo
import com.UMCfront.religo.src.menu.data.SurveyResponse
import com.UMCfront.religo.src.menu.retrofit.SignUp
import kotlinx.android.synthetic.main.activity_menu9.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MenuActivity9 : AppCompatActivity() {
    val nickname = "nickname"
    // val preference by lazy {getSharedPreferences("MenuActivity9", Context.MODE_PRIVATE)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu9)

        applicationContext.getSharedPreferences("MenuActivity9", MODE_PRIVATE)

        // ★ menu1~8에서 저장했던 shared preference 값 불러오기
        val menu1 = getSharedPreferences("MenuActivity1", MODE_PRIVATE)
        val menu2 = getSharedPreferences("MenuActivity2", MODE_PRIVATE)
        val menu3 = getSharedPreferences("MenuActivity3", MODE_PRIVATE)
        val menu4 = getSharedPreferences("MenuActivity4", MODE_PRIVATE)
        val menu5 = getSharedPreferences("MenuActivity5", MODE_PRIVATE)
        val menu6 = getSharedPreferences("MenuActivity6", MODE_PRIVATE)
        val menu7 = getSharedPreferences("MenuActivity7", MODE_PRIVATE)
        val menu8 = getSharedPreferences("MenuActivity8", MODE_PRIVATE)


        // 이전으로 버튼
        menu9_back_btn.setOnClickListener {
            val intent = Intent(this, MenuActivity8::class.java)
            startActivity(intent)
        }

        // shared preferences
        // ★★★ menu 1~9에서 shared preferences에 저장해둔 값 서버로 POST 하기
        join_btn.setOnClickListener {
            SPEditor.putString(nickname, nickNameField.text.toString()).apply()
            // ★ ↑ (중복확인) 버튼 누르고 확인 되면 그때 자동으로 shared preferences에 저장되게 하기

            val question_1 = menu1.getString("question_1","")
            val address = menu2.getString("address","")
            val question_2 = menu3.getString("question_2","")
            val question_3 = menu4.getString("question_3","")
            val hashTag = menu5.getString("hashTag","")
            val question_4 = menu6.getString("question_4","")
            val question_5 = menu6.getString("question_5","")
            val question_6 = menu7.getString("question_6","")
            val question_7 = menu7.getString("question_7","")
            val question_8 = menu8.getString("question_8","")
            val question_9 = menu8.getString("question_9","")
            // ApplicationClass에서 getString 함수 생성 후 사용 ↓
            val nickname = ApplicationClass.SharedPreferences.getString("nickname","")


            // 값 확인용
            Log.d("q1", question_1.toString())
            Log.d("주소", address.toString())
            Log.d("q2", question_2.toString())
            Log.d("q3", question_3.toString())
            Log.d("hashTag", hashTag.toString())
            Log.d("q4", question_4.toString())
            Log.d("q5", question_5.toString())
            Log.d("q6", question_6.toString())
            Log.d("q7", question_7.toString())
            Log.d("q8", question_8.toString())
            Log.d("q9", question_9.toString())
            Log.d("닉네임", nickname.toString())


            // 서버로 POST할 data
            val data = SurveyInfo(question_1.toString(),
                address.toString(),
                question_2.toString(),
                question_3.toString(),
                hashTag.toString(),
                question_4.toString(),
                question_5.toString(),
                question_6.toString(),
                question_7.toString(),
                question_8.toString(),
                question_9.toString(),
                nickname.toString())

            val retrofit = ApplicationClass.sRetrofit
            val SignUpService = retrofit.create(SignUp::class.java)

            SignUpService.signup(data).enqueue(object : Callback<SurveyResponse> {
                override fun onResponse(
                    call: Call<SurveyResponse>,
                    response: Response<SurveyResponse>
                ) {
                    Log.d("response", response.toString())
                    Log.d("body", response.body().toString())
                }

                override fun onFailure(call: Call<SurveyResponse>, t: Throwable) {
                    // 실패
                    Log.d("response", t.message.toString())
                    Log.d("response", "fail")
                }
            })

            // menu10 페이지로 이동
            val intent = Intent(this, MenuActivity10::class.java)
            startActivity(intent)
        }
    }
}