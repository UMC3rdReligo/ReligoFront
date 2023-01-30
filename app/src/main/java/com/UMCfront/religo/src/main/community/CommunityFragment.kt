package com.UMCfront.religo.src.main.community

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity


class CommunityFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_community, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val churchEntrance=view.findViewById<ImageView>(R.id.community_entrance)


        churchEntrance!!.setOnClickListener {

            // fragment간 이동

            (activity as MainActivity?)?.changeFragment(CommunityChurchFragment.newInstance())

//            activity?.let{
//                val intent = Intent(context, CommunityChurchActivity::class.java)
//                startActivity(intent)
//            }


        }

        val allViewMore=view.findViewById<ImageView>(R.id.community_all_viewmore)

        allViewMore.setOnClickListener{

            (activity as MainActivity?)?.changeFragment(CommunityAllFragment.newInstance())
            
//            activity?.let{
//                val intent = Intent(context, CommunityAllActivity::class.java)
//                startActivity(intent)
//
//            }
        }

        val platformMore=view.findViewById<ImageView>(R.id.community_platform_viewmore)

        platformMore.setOnClickListener {
            (activity as MainActivity?)?.changeFragment(CommunityPlatformFragment.newInstance())
        }

        var communityAllList= mutableListOf<String>()
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")


        val rv=view.findViewById<RecyclerView>(R.id.allRV)

        val communityAdapter= CommunityRVAdapter1(communityAllList)


        rv.adapter=communityAdapter

        // 글 클릭 구현
        communityAdapter.itemClick=object:CommunityRVAdapter1.ItemClick{
            override fun onClick(view: View, position: Int) {
                (activity as MainActivity?)?.changeFragment(CommunityAllArticleFragment.newInstance())
            }

        }


        rv.layoutManager= LinearLayoutManager(this.context)

        //
        var communityPlatformList= mutableListOf<String>()
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")
        communityPlatformList.add("안녕하세용~~~")

        val platformAdapter= CommunityRVAdapter1(communityPlatformList)
        val platRv=view.findViewById<RecyclerView>(R.id.platformRV)

        platRv.adapter=platformAdapter

        // 글 클릭 구현
        platformAdapter.itemClick=object:CommunityRVAdapter1.ItemClick{
            override fun onClick(view: View, position: Int) {
                (activity as MainActivity?)?.changeFragment(CommunityPlatformFragment.newInstance())
            }

        }

    }

    companion object {
        // fragment 인스턴스 사용하기 위해 companion object 사용
        fun newInstance(): CommunityFragment {
            return CommunityFragment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
    }


}