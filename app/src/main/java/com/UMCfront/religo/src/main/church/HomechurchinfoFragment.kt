package com.UMCfront.religo.src.main.church

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.church.adapter.ChurchDetailAdapter
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1
import com.UMCfront.religo.src.main.home.HomeFragment


class HomechurchinfoFragment : Fragment() {
    //val homeFragment:HomeFragment=HomeFragment()

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
        val gotohomefromchurchinfo = view.findViewById<ImageView>(R.id.churchinfo_backbtn_imageView)

        //homefrag로 이동
        gotohomefromchurchinfo.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(HomeFragment())
        }

        //1회 방문 frag로 이동
       churchtry!!.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(HomeChurchtryFragment())
        }

        //가입하기 frag로 이동
        churchsignup!!.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(HomeChurchsignupFragment())
        }


        //이부분 수정 필요 => 오브젝트 변화 X .-> 교회 소개에 대한 도움말 dialog로 표현하기
        //오브젝트 클릭 부분 ( 교회소개 변화 )
        val churchdetail =  view.findViewById<ImageButton>(R.id.churchinfo_churchdetail_imageButton)
        val churchdetailbackground = view.findViewById<LinearLayout>(R.id.churchinfo_churchinfo_background)
        val detailtext = view.findViewById<TextView>(R.id.churchinfo_churchinfo_textView)

        var detailobchecer:Int = 0
        churchdetail.setOnClickListener {

            if(detailobchecer == 0){
                detailtext.setText("\n\n\n\n\n 목동 교회 입니다 \n\n\n\n\n")
                detailobchecer = 1
                churchdetail.setImageResource(R.drawable.celebration)
                churchdetailbackground.setBackgroundResource(R.drawable.home_dateformeeting_background)
                churchdetailbackground.setBackgroundResource(R.drawable.home_location_background)

            }
            else{
                detailtext.setText("안녕하세요 목동교회입니다(TEST TEXT)")
                detailobchecer = 0
                churchdetail.setImageResource(R.drawable.circle)
                churchdetailbackground.setBackgroundResource(R.drawable.home_dateformeeting_background)

            }

        }

        var homereviewAllList= mutableListOf<String>()
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        homereviewAllList.add("안녕하세요 이번에 새로 가입했습니다.")


        val homerv= view.findViewById<RecyclerView>(R.id.churchinfo_review_RecyclerView)
        val homeReviewAdapter= ChurchDetailAdapter(homereviewAllList)


        val homeReviewAll = view.findViewById<ImageView>(R.id.churchinfo_review_viewmore_imageview)

        homeReviewAll.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(ChurchReviewAllFragment.newInstance())
        }


        homerv.adapter=homeReviewAdapter

//        homeReviewAdapter.itemClick=object:CommunityRVAdapter1.ItemClick{
//            override fun onClick(view: View, position: Int) {
//                (activity as MainActivity?)?.changeFragment(CommunityAllArticleFragment.newInstance())
//            }
//
//        }

        homerv.layoutManager= LinearLayoutManager(this.context)





    }

}