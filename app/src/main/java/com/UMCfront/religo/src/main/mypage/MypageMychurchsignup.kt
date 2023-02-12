package com.UMCfront.religo.src.main.mypage

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.src.main.church.adapter.ChurchDetailAdapter
import com.UMCfront.religo.src.main.church.data.ChurchDetailRetrofitService
import com.UMCfront.religo.src.main.church.data.HomeSignupRetorfitInterface
import com.UMCfront.religo.src.main.church.data.model.ChurchDetailResponse
import com.UMCfront.religo.src.main.church.data.model.ChurchSignup
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MypageMychurchsignup: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_mypage_churchtry, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val retrofit = ApplicationClass.sRetrofit
        val mychurchSignupService = retrofit.create(MypageChurchResponseService::class.java)
        val churchService=retrofit.create(ChurchDetailRetrofitService::class.java)

        var MypageMychurchAdapter= mutableListOf<String>()


        mychurchSignupService.getMypageChurchSignup().enqueue(
            object : Callback<MypageChurchResopnse> {

                @SuppressLint("ResourceType")
                override fun onResponse(
                    call: Call<MypageChurchResopnse>,
                    response: Response<MypageChurchResopnse>
                ) {
                    if (response.isSuccessful) {
//                    Toast.makeText(getActivity(),response.body().toString(),Toast.LENGTH_SHORT).show()

                        Log.d("p101test", response.body().toString())
                        var data = response.body() as MypageChurchResopnse// GsonConverter를 사용해 데이터매핑

                        if(data.code == 200) with(churchService) {
                            getChurchDetail(data.result.churchId).enqueue(object :retrofit2.Callback<ChurchDetailResponse> {
                                override fun onResponse(
                                    call: Call<ChurchDetailResponse>,
                                    response: Response<ChurchDetailResponse>
                                ) {
                                    val res = response.body() as ChurchDetailResponse
                                    var info = res.result.info.name
                                    MypageMychurchAdapter.add(info)
                                    val mychurchsignup =
                                        view.findViewById<RecyclerView>(R.id.mypage_churchtry_recyclerview)
                                    val mychurchsignupAdapter =
                                        MypageMychurchAdapter(MypageMychurchAdapter)
                                    mychurchsignup.adapter = mychurchsignupAdapter
                                    mychurchsignup.layoutManager =
                                        LinearLayoutManager(getActivity())
                                }

                                override fun onFailure(
                                    call: Call<ChurchDetailResponse>,
                                    t: Throwable
                                ) {
                                    //실패시
                                }

                            })

                        }
                        else {
//                            MypageMychurchAdapter.add("안녕하세요 이번에 새로 가입했습니다.")
//                            val homerv= view.findViewById<RecyclerView>(R.id.mypage_churchtry_recyclerview)
//                            val homeReviewAdapter= ChurchDetailAdapter(MypageMychurchAdapter)
//                            homerv.adapter = homeReviewAdapter

                        }

                    }
                }

                override fun onFailure(call: Call<MypageChurchResopnse>, t: Throwable) {
                    Log.d("p102test", "실패$t")
                }

            }
        )

    }


}