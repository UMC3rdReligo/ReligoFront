package com.UMCfront.religo.src.main.church

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity

class HomechurchinfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {



        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_churchinfo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //회면 이동 부분
        val churchtry = view.findViewById<Button>(R.id.home_churchtry_button)
        val churchsignup = view.findViewById<Button>(R.id.home_churchsignup_button)

        churchtry!!.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(HomeChurchtryFragment())
        }

        churchsignup!!.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(HomeChurchsignupFragment())
        }


        //오브젝트 클릭 부분 ( 교회소개 변화 )
        val churchdetail =  view.findViewById<ImageButton>(R.id.churchinfo_churchdetail_imageButton)
        val detailtext = view.findViewById<TextView>(R.id.churchinfo_churchinfo_textView)


        var detailobchecer:Int = 0
        churchdetail.setOnClickListener {

            if(detailobchecer == 0){
                detailtext.setText("\n\n\n\n\n 목동 교회 입니다 \n\n\n\n\n")
                detailobchecer = 1
                churchdetail.setImageResource(R.drawable.celebration)
            }
            else{
                detailtext.setText("안녕하세요 목동교회입니다(TEST TEXT)")
                detailobchecer = 0
                churchdetail.setImageResource(R.drawable.circle)

            }

        }


    }

}