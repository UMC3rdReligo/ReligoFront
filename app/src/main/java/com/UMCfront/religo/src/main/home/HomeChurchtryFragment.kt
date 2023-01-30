package com.UMCfront.religo.src.main.home

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
        editor.putString("name",trynumber.text.toString())
        editor.putString("name",trydate.toString())


        editor.apply()

        Toast.makeText(getActivity(),tryname.text,Toast.LENGTH_SHORT).show();


    }



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //가입 데이터 전송 버튼
        val putdata = view.findViewById<Button>(R.id.home_sendinfo_tochurch)
        putdata!!.setOnClickListener {
            savepref()
        }

        val btnStartDate = view.findViewById<LinearLayout>(R.id.home_userdate_box)
        btnStartDate.setOnClickListener{
            Log.d("HomeChurchFragment","prev")
            showDatePicker()
//            val calendar:Calendar = Calendar.getInstance()
//
//            val year = calendar.get(Calendar.YEAR)
//            val mon = calendar.get(Calendar.MONTH)
//            val day = calendar.get(Calendar.DAY_OF_MONTH)
//
//            calendar.set(year,mon,day)

        }

        }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun showDatePicker() {
        Log.d("HomeChurchFragment","next")

        val cal = Calendar.getInstance()
        DatePickerDialog(Activity(), DatePickerDialog.OnDateSetListener { datePicker, y, m, d->
            Toast.makeText(Activity(), "$y-$m-$d", Toast.LENGTH_SHORT).show()
        }, cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DATE)).show()
        Log.d("HomeChurchFragment","next2")

    }

}



