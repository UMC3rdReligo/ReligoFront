package com.UMCfront.religo.src.main.mypage

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
import com.UMCfront.religo.src.main.church.data.ChurchDetailRetrofitService
import com.UMCfront.religo.src.main.church.data.model.ChurchDetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MypageMychurchtry : Fragment() {

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
        val mychurchtryService = retrofit.create(MypageChurchtryResposeRetrofitInterface::class.java)
        val churchService=retrofit.create(ChurchDetailRetrofitService::class.java)
        var MypageMychurchtryAdapter= mutableListOf<String>()


        mychurchtryService.getMypageChurchtry().enqueue(
            object : Callback<MypageChurchtryResopnse> {
                override fun onResponse(
                    call: Call<MypageChurchtryResopnse>,
                    response: Response<MypageChurchtryResopnse>
                ) {
                    if (response.isSuccessful) {
//                    Toast.makeText(getActivity(),response.body().toString(),Toast.LENGTH_SHORT).show()

                        Log.d("p1011test", response.body().toString())
                        var data = response.body() as MypageChurchtryResopnse// GsonConverter를 사용해 데이터매핑
                        Log.d("p1011test", data.result.count().toString())
                        for(i in 0 .. (data.result.count()-1))with(churchService){

                            getChurchDetail(data.result[i].churchId).enqueue(object :retrofit2.Callback<ChurchDetailResponse> {

                                override fun onResponse(
                                    call: Call<ChurchDetailResponse>,
                                    response: Response<ChurchDetailResponse>
                                ) {

                                    val res = response.body() as ChurchDetailResponse
                                    var info = res.result.info.name
                                    MypageMychurchtryAdapter.add(info)
                                    Log.d("p1011test",MypageMychurchtryAdapter.toString()+i)

                                    if(i==data.result.count()-1){
                                        Log.d("p1011test",MypageMychurchtryAdapter.toString())
                                        val mychurchtry = view.findViewById<RecyclerView>(R.id.mypage_churchtry_recyclerview)
                                        val mychurchtryAdapter = MypageMychurchAdapter(MypageMychurchtryAdapter)
                                        mychurchtry.adapter = mychurchtryAdapter
                                        mychurchtry.layoutManager = LinearLayoutManager(getActivity())
                                    }

                                }
                                override fun onFailure(
                                    call: Call<ChurchDetailResponse>,
                                    t: Throwable
                                ) {
                                    Log.d("p1011test", "실패$t")
                                }
                            })

                        }

                    }
                }
                override fun onFailure(call: Call<MypageChurchtryResopnse>, t: Throwable) {
                    Log.d("p103test", "실패$t")
                }

            }
        )



    }


}