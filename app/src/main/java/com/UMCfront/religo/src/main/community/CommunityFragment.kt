package com.UMCfront.religo.src.main.community

import android.content.Intent
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


class CommunityFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view=inflater.inflate(R.layout.fragment_community, container, false)

        val churchEntrance=view.findViewById<ImageView>(R.id.community_entrance)


        churchEntrance!!.setOnClickListener {
            activity?.let{
                val intent = Intent(context, CommunityChurchActivity::class.java)
                startActivity(intent)
            }


        }

        var communityAllList= mutableListOf<String>()
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")
        communityAllList.add("안녕하세요 이번에 새로 가입했습니다.")


        val communityAdapter= CommunityRVAdapter1(communityAllList)

        val rv=view.findViewById<RecyclerView>(R.id.allRV)
        rv.adapter=communityAdapter


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


        return view
    }

    companion object {
        // fragment 인스턴스 사용하기 위해 companion object 사용
        fun newInstance(): CommunityFragment {
            return CommunityFragment()
        }
    }


}