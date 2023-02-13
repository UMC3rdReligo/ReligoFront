package com.UMCfront.religo.src.main.church

import android.annotation.SuppressLint
import android.app.Activity
import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.church.data.HomeSignupRetorfitInterface
import com.UMCfront.religo.src.main.church.data.HometryRetrofitInterface
import com.UMCfront.religo.src.main.church.data.model.ChurchSignup
import com.UMCfront.religo.src.main.church.data.model.ChurchSignupResult
import com.UMCfront.religo.src.main.church.data.model.ChurchtryResult
import com.UMCfront.religo.src.main.home.HomeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomeChurchtryFragment :Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        //jungmin
        //번들에서 교회 이름가져오기
//        val churchId=requireArguments().getInt("churchId")
//
//        Log.d("p101test", "$churchId")
//
//
//
//        val view=inflater.inflate(R.layout.fragment_home_churchtry, container, false)


            // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_churchtry, container, false)

    }



    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("UseRequireInsteadOfGet")
    private fun savepref(){


        val retrofit = ApplicationClass.sRetrofit
        val churchtryService = retrofit.create(HometryRetrofitInterface::class.java)
        val churchId = ApplicationClass.SharedPreferences.getInt("churchId",0)

        val signname = view!!.findViewById<EditText>(R.id.home_username_textView)
        val signnumber = view!!.findViewById<EditText>(R.id.home_usernumber_textView)
        val signdate = view!!.findViewById<TextView>(R.id.home_date_textView)


        val churchtryinfo = ChurchtryResult(
            signname.text.toString(),
            signnumber.text.toString(),
            "새로가입하였습니다",
            signdate.toString(),
        )

        churchtryService.sendUsertry(churchId,churchtryinfo).enqueue(object :
            Callback<ChurchSignup> {
            override fun onResponse(call: Call<ChurchSignup>, response: Response<ChurchSignup>) {
                Log.d("p101test", "5")

                if (response.isSuccessful) {
//                    Toast.makeText(getActivity(),response.body().toString(),Toast.LENGTH_SHORT).show()
                    Log.d("p101test", response.body().toString())
                    var data = response.body() // GsonConverter를 사용해 데이터매핑
                }
            }

            override fun onFailure(call: Call<ChurchSignup>, t: Throwable) {
//                Toast.makeText(getActivity(),"fail",Toast.LENGTH_SHORT).show()
                Log.d("p102test", "실패$t")
            }

        })


    }



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        //뒤로가기 버튼
        val churchninfotryback = view.findViewById<ImageView>(R.id.home_churchnifo_churchtryupback_btn)
        churchninfotryback.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(HomechurchinfoFragment())

        }

        //가입 데이터 전송 버튼
        val putdata = view.findViewById<Button>(R.id.home_sendinfo_tochurch)
        putdata!!.setOnClickListener {
            savepref()
        }

        val btnDatetext = view.findViewById<TextView>(R.id.home_date_textView)
        val btnStartDate = view.findViewById<LinearLayout>(R.id.home_userdate_box)
        btnStartDate.setOnClickListener{

            val cal = Calendar.getInstance()
            var year = cal.get(Calendar.YEAR)
            var month = cal.get(Calendar.MONTH)
            var day = cal.get(Calendar.DATE)


            val datePickerDialog = DatePickerDialog(requireContext(),{_,year,month,day ->
                btnDatetext.text=
                    year.toString()+"/"+(month+1).toString()+"/"+day.toString()
            },year,month,day)
            datePickerDialog.show()
        }
        super.onViewCreated(view, savedInstanceState)
    }


    companion object {
        fun newInstance(): HomeChurchtryFragment {
            return HomeChurchtryFragment()
        }
    }



}



