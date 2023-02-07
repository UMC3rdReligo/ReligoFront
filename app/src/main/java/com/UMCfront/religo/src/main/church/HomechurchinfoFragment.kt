package com.UMCfront.religo.src.main.church

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.config.ApplicationClass
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.church.adapter.ChurchDetailAdapter
import com.UMCfront.religo.src.main.church.data.ChurchDetailRetrofitService
import com.UMCfront.religo.src.main.church.data.model.ChurchDetailResponse
import com.UMCfront.religo.src.main.home.HomeFragment
import retrofit2.Call
import retrofit2.Response


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

        //jungmin
        // 번들에서 churchId 가져오기
        val churchId=requireArguments().getInt("churchId")
        Log.d("home4",churchId.toString())
        // church id를 파라미터로 넣어서 값 받아오기
        val retrofit= ApplicationClass.sRetrofit
        val churchService=retrofit.create(ChurchDetailRetrofitService::class.java)

        churchService.getChurchDetail(churchId).enqueue(object :retrofit2.Callback<ChurchDetailResponse> {

            override fun onResponse(
                call: Call<ChurchDetailResponse>,
                response: Response<ChurchDetailResponse>
            ) {
                val res=response.body() as ChurchDetailResponse


                var info=res.result.info

                //jungmin

                //상단 교회이름
                val churchName=view.findViewById<TextView>(R.id.home_churchinfoname_textView)
                churchName.text=info.name

                //교회 주소
                view.findViewById<TextView>(R.id.churchinfo_churchinfo_textView).text=info.address


                // 교회 사이트
                view.findViewById<TextView>(R.id.churchinfo_church_www_textView).text=info.homepage
                //목사
                view.findViewById<TextView>(R.id.churchinfo_churchpastor_textView).text=info.minister

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
                    val bundle=Bundle()
                    //jungmin
                    bundle.putInt("churchId",churchId)
                    HomeChurchtryFragment().arguments=bundle
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
                        detailtext.text=info.introduction
                        //detailtext.setText("\n\n\n\n\n 목동 교회 입니다 \n\n\n\n\n")
                        detailobchecer = 1
                        churchdetail.setBackgroundResource(R.drawable.home_plus2_btn)
                        churchdetailbackground.setBackgroundResource(R.drawable.home_location_background)

                    }
                    else{
                        //detailtext.setText("안녕하세요 목동교회입니다(TEST TEXT)")
                        detailtext.text=info.introduction
                        detailobchecer = 0
                        churchdetail.setBackgroundResource(R.drawable.home_plus_btn)
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

                //jungmin

                //예배일정 추가
                view.findViewById<TextView>(R.id.churchinfo_churchdate_textView).text=
                    info.schedule

                //문의하기 추가
                view.findViewById<TextView>(R.id.churchinfo_churchnum_textView).text=
                    info.phoneNum


                homerv.layoutManager= LinearLayoutManager(context)
            }

            override fun onFailure(call: Call<ChurchDetailResponse>, t: Throwable) {
                Toast.makeText(context,"연결 오류", Toast.LENGTH_LONG).show()
            }

        })



    }

    inner class ChurchDetail(
        name:String, address:String, homepage:String, minister:String,
        introduction:String, imgUrl: List<String>, schedule:String, phoneNum:String
    ){
        var name:String=""
        var address:String=""
        var homepage:String=""
        var minister:String=""
        var introduction:String=""
        var imgUrl:List<String>
        var schedule:String=""
        var phoneNum:String=""

        init {
            this.name=name
            this.address=address
            this.homepage=homepage
            this.minister=minister
            this.introduction=introduction
            this.imgUrl= imgUrl.toList()
            this.schedule=schedule
            this.phoneNum=phoneNum
        }

    }

}