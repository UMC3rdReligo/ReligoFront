package com.UMCfront.religo.src.main.home

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

import androidx.viewpager2.widget.ViewPager2
import com.UMCfront.religo.R
import com.UMCfront.religo.databinding.FragmentCommunityAllBinding
import com.UMCfront.religo.databinding.FragmentHomeBinding
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.church.HomechurchinfoFragment
import com.UMCfront.religo.src.main.community.CommunityAllArticleFragment
import com.UMCfront.religo.src.main.community.CommunityAllWritingFragment
import com.UMCfront.religo.src.main.community.adapter.CommunityGridAdapter
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1
import com.UMCfront.religo.src.main.home.adapter.HomeViewPagerAdapter
import com.UMCfront.religo.src.main.home.adapter.PagerFragmentStateAdapter


class HomeFragment : Fragment() {

    val homechurchinfoFragment=HomechurchinfoFragment();

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view=inflater.inflate(R.layout.fragment_home, container, false)



        // home- 교회추천 viewpager
        val viewPager2Church = view.findViewById<ViewPager2>(R.id.home_churchrecommend_viewpager);
        val churchRecommendList= mutableListOf<HomeChurchViewItem>()
        churchRecommendList.add(HomeChurchViewItem("목동교회1","목동교회2"))
        churchRecommendList.add(HomeChurchViewItem("목동교회3","목동교회4"))
        churchRecommendList.add(HomeChurchViewItem("목동교회5","목동교회6"))
        churchRecommendList.add(HomeChurchViewItem("목동교회7","목동교회8"))

        val churchViewPagerAdapter= HomeViewPagerAdapter(churchRecommendList)
        viewPager2Church.adapter= churchViewPagerAdapter

        val homeCommunityList= mutableListOf<String>()
        homeCommunityList.add("안녕하세용~~")
        homeCommunityList.add("안녕하세용~~")
        homeCommunityList.add("안녕하세용~~")
        homeCommunityList.add("안녕하세용~~")
        homeCommunityList.add("안녕하세용~~")


        // 더 알아보기 클릭

        churchViewPagerAdapter.churchItemClick=object :HomeViewPagerAdapter.ChurchViewMoreItemClick{
            override fun onClick(view: View, position: Int) {
                (activity as MainActivity?)?.changeFragment(homechurchinfoFragment)
            }
        }

        val communityRecyclerView=view.findViewById<RecyclerView>(R.id.home_community_allRV)
        communityRecyclerView.adapter=CommunityRVAdapter1(homeCommunityList)


        return view

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }


    // church view pager 객체 지정

    inner class HomeChurchViewItem constructor(text1:String,text2:String){

        var text1:String="";
        var text2:String="";

        init{
            this.text1=text1;
            this.text2=text2;

        }



    }

    companion object {
        fun newInstance(): HomeFragment {
            return HomeFragment()
        }
    }
}