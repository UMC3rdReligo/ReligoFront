package com.UMCfront.religo.src.main.church

import android.annotation.SuppressLint
import android.media.Image
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.church.adapter.ChurchDetailGridAdapter
import com.UMCfront.religo.src.main.community.CommunityChurchFragment

class ChurchinfoWriteFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_churchinfo_write, container, false)
        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //데이터 전달 버튼 클릭시
        val writefinish = view.findViewById<Button>(R.id.churchinfo_write_finish)
        writefinish.setOnClickListener {
            writeend()

            (activity as MainActivity?)?.changeFragment(ChurchReviewAllFragment())
        }

        val writebackbtn = view.findViewById<ImageView>(R.id.home_churchnifo_writeback_btn)
        writebackbtn.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(ChurchReviewAllFragment())

        }

    }

    //데이터 전달 함수
    @SuppressLint("UseRequireInsteadOfGet")
    private fun writeend() {

        val title = view!!.findViewById<EditText>(R.id.churchinfo_review_title)
        val content = view!!.findViewById<EditText>(R.id.churchinfo_review_content)

        Toast.makeText(context,title.text, Toast.LENGTH_LONG).show()
        Toast.makeText(context,content.text,Toast.LENGTH_LONG).show()

    }


    companion object {
        fun newInstance(): ChurchinfoWriteFragment {
            return ChurchinfoWriteFragment()
        }
    }

}