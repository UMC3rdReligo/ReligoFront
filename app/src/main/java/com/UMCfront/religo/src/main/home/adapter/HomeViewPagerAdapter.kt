package com.UMCfront.religo.src.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1
import com.UMCfront.religo.src.main.home.HomeFragment

class HomeViewPagerAdapter(val items:MutableList<HomeFragment.HomeChurchViewItem>): RecyclerView.Adapter<HomeViewPagerAdapter.ViewHolder>() {

    // 더 알아보기 클릭
    interface ChurchViewMoreItemClick{
        fun onClick(view:View,position:Int)
    }

    var churchItemClick: ChurchViewMoreItemClick?=null


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: HomeFragment.HomeChurchViewItem){
            val rv_text1=itemView.findViewById<TextView>(R.id.home_church_item1_text)
            val rv_text2=itemView.findViewById<TextView>(R.id.home_church_item2_text)
            rv_text1.text=item.text1
            rv_text2.text=item.text2

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.home_viewpager_church_item,parent,false)
        // 뷰 홀더에 뷰 넣어주기
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
        if(churchItemClick!=null){
            holder.itemView.findViewById<ImageView>(R.id.home_church_item1_view_more).setOnClickListener{v->
                churchItemClick?.onClick(v,position)

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size;
    }
}