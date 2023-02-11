package com.UMCfront.religo.src.main.church

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.graphics.Color
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.church.data.HomeSignupRetorfitInterface
import com.UMCfront.religo.src.main.church.data.model.ChurchSignup
import com.UMCfront.religo.src.main.church.data.model.ChurchSignupResult
import com.UMCfront.religo.src.main.home.HomeFragment
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeChurchsignupFragment:Fragment() {

    val emailitems = arrayOf("example.com","gmail.com","naver.com")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


//        val churchId2= requireArguments().getInt("churchId")
//
//        Log.d("p101test", "$churchId2")
        Log.d("p101test","123")

        return inflater.inflate(R.layout.fragment_home_churchsignup, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun signupsavepref(){

        Log.d("p101test", "1")



        val signname = view!!.findViewById<EditText>(R.id.home_username_signup_textView)
        val signnumber = view!!.findViewById<EditText>(R.id.home_usernumber_signup_textView)
        val signbirth = view!!.findViewById<TextView>(R.id.home_birth_signup_textView)
        val signlocate = view!!.findViewById<EditText>(R.id.home_location_signup_textView)
        val signemail = view!!.findViewById<EditText>(R.id.home_email_signup_textView)
        val signemaillast = view!!.findViewById<Spinner>(R.id.home_email_signup_emailafter_Spinner)
        val signguid = view!!.findViewById<EditText>(R.id.home_guide_signup_textView)
        val signdate = view!!.findViewById<TextView>(R.id.home_date_textView)

        Log.d("p101test", "2")


        val churchSignupinfo = ChurchSignupResult(
            signname.text.toString(),
            signbirth.text.toString(),
            signnumber.text.toString(),
            signlocate.text.toString(),
            signemail.text.toString()+"@"+signemaillast.selectedItem.toString(),
            signguid.text.toString(),
            signguid.text.toString(),
            signdate.text.toString(),
        )

        Log.d("p101test", "3")



        val retrofit = ApplicationClass.sRetrofit
        Log.d("p101test", "4")

        val churchSignupService = retrofit.create(HomeSignupRetorfitInterface::class.java)
        Log.d("p101test", "5")


        val churchId=43
        Log.d("p101test", "6")


        churchSignupService.sendUserSignup(churchId,churchSignupinfo).enqueue(object :
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


    companion object {
        fun newInstance(): HomeChurchsignupFragment {
            return HomeChurchsignupFragment()
        }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        val churchninfosignupback = requireView().findViewById<ImageView>(R.id.home_churchnifo_churchsignupback_btn)
        churchninfosignupback.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(HomechurchinfoFragment())

        }

        val spinner = requireView().findViewById<Spinner>(R.id.home_email_signup_emailafter_Spinner)
        spinner?.adapter = ArrayAdapter(activity?.applicationContext!!, R.layout.churchinfo_spinner_text, emailitems) as SpinnerAdapter



        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{

            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val value = parent!!.getItemAtPosition(position).toString()
                if(value == emailitems[0]){
                    (view as TextView).setTextColor(Color.GRAY)
                }
            }

        }


        val signupputdata = view.findViewById<Button>(R.id.home_sendinfo_tochurch)

        signupputdata!!.setOnClickListener {
            signupsavepref()
        }



        val signupbtnDatetext = view.findViewById<TextView>(R.id.home_date_textView)
        val signupbtnStartDate = view.findViewById<LinearLayout>(R.id.home_userdate_box)

        signupbtnStartDate.setOnClickListener{

            val cal = Calendar.getInstance()
            var year = cal.get(Calendar.YEAR)
            var month = cal.get(Calendar.MONTH)
            var day = cal.get(Calendar.DATE)


            val datePickerDialog = DatePickerDialog(requireContext(),{_,year,month,day ->
                signupbtnDatetext.text=
                    year.toString()+"/"+(month+1).toString()+"/"+day.toString()
            },year,month,day)
            datePickerDialog.show()
        }

        val signupbtnbirthtext = view.findViewById<TextView>(R.id.home_birth_signup_textView)
        val signupbtnbirthStartDate = view.findViewById<LinearLayout>(R.id.home_userbirth_box)

        signupbtnbirthStartDate.setOnClickListener{

            val cal = Calendar.getInstance()
            var year = cal.get(Calendar.YEAR)
            var month = cal.get(Calendar.MONTH)
            var day = cal.get(Calendar.DATE)


            val datePickerDialog = DatePickerDialog(requireContext(),{_,year,month,day ->
                signupbtnbirthtext.text=
                    year.toString()+"/"+(month+1).toString()+"/"+day.toString()
            },year,month,day)
            datePickerDialog.show()
        }


    }

}

