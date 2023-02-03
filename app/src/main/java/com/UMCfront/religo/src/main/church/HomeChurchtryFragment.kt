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
import com.UMCfront.religo.src.main.MainActivity


class HomeChurchtryFragment :Fragment(){


    var dateString = ""

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        val view=inflater.inflate(R.layout.fragment_home_churchtry, container, false)


            // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_churchtry, container, false)

    }



    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("UseRequireInsteadOfGet")
    private fun savepref(){
        val SharedPreferences = context!!.getSharedPreferences("try_settiongs",Context.MODE_PRIVATE)
        val editor = SharedPreferences.edit()

        val tryname = view!!.findViewById<EditText>(R.id.home_username_textView)
        val trynumber = view!!.findViewById<EditText>(R.id.home_usernumber_textView)
        val trydate = view!!.findViewById<TextView>(R.id.home_date_textView)


//2001.07.04 AD at 12:08:56 PDT





        editor.putString("name",tryname.text.toString())
        editor.putString("number",trynumber.text.toString())
        editor.putString("date",trydate.toString())


        editor.apply()

        Toast.makeText(getActivity(),tryname.text,Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),trynumber.text,Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),trydate.text,Toast.LENGTH_SHORT).show();


    }



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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

    }




}



