package com.UMCfront.religo.src.main.home

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.FragmentCommunityChurchWritingBinding

class HomeChurchtryFragment :Fragment(){



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_churchtry, container, false)
    }


    @SuppressLint("UseRequireInsteadOfGet")
    private fun savepref(){
        val SharedPreferences = context!!.getSharedPreferences("try_settiongs",Context.MODE_PRIVATE)
        val editor = SharedPreferences.edit()

        val tryname = view!!.findViewById<EditText>(R.id.home_username_textView)
        val trynumber = view!!.findViewById<EditText>(R.id.home_usernumber_textView)
        val trydate = view!!.findViewById<EditText>(R.id.home_date_textView)

        editor.putString("name",tryname.text.toString())
        editor.putString("name",trynumber.text.toString())
        editor.putString("name",trydate.text.toString())


        editor.apply()

        Toast.makeText(getActivity(),tryname.text,Toast.LENGTH_SHORT).show();


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val putdata = view.findViewById<Button>(R.id.home_sendinfo_tochurch)

        putdata!!.setOnClickListener {
            savepref()
        }


    }




}


