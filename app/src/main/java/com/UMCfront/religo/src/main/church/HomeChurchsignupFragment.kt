package com.UMCfront.religo.src.main.church

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Context
import android.icu.util.Calendar
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R

class HomeChurchsignupFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_churchsignup, container, false)
    }

    @SuppressLint("UseRequireInsteadOfGet")
    private fun signupsavepref(){
        val SharedPreferences = context!!.getSharedPreferences("try_settiongs", Context.MODE_PRIVATE)
        val editor = SharedPreferences.edit()

        val signname = view!!.findViewById<EditText>(R.id.home_username_signup_textView)
        val signnumber = view!!.findViewById<EditText>(R.id.home_usernumber_signup_textView)
        val signbirth = view!!.findViewById<EditText>(R.id.home_birth_signup_textView)
        val signlocate = view!!.findViewById<EditText>(R.id.home_location_signup_textView)
        val signemail = view!!.findViewById<EditText>(R.id.home_email_signup_textView)
        val signguid = view!!.findViewById<EditText>(R.id.home_guide_signup_textView)
        val signdate = view!!.findViewById<EditText>(R.id.home_date_textView)


        editor.putString("name",signname.text.toString())
        editor.putString("number",signnumber.text.toString())
        editor.putString("birth",signbirth.text.toString())
        editor.putString("locate",signlocate.text.toString())
        editor.putString("email",signemail.text.toString())
        editor.putString("guide",signguid.text.toString())
        editor.putString("date",signdate.text.toString())


        editor.apply()

        Toast.makeText(getActivity(),signname.text, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),signnumber.text, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),signbirth.text, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),signlocate.text, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),signemail.text, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),signguid.text, Toast.LENGTH_SHORT).show();
        Toast.makeText(getActivity(),signdate.text, Toast.LENGTH_SHORT).show();


    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val signupputdata = view.findViewById<Button>(R.id.home_sendinfo_tochurch)
        /*

        signupputdata!!.setOnClickListener {
            signupsavepref()
        }

         */

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