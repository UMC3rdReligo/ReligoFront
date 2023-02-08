package com.UMCfront.religo.src.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.home.HomeFragment

class HomeCommunityRVAdapter(val items:MutableList<HomeFragment.HomeCommunity>):RecyclerView.Adapter<HomeCommunityRVAdapter.ViewHolder>() {

    // 아이템 클릭
    interface ItemClick{
        fun onClick(view:View,position:Int)
    }

    var itemClick:ItemClick?=null

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: HomeFragment.HomeCommunity){
            // recently가 true이면 new 이미지 넣어주기

            val rv_text=itemView.findViewById<TextView>(R.id.community_rv_text)
            val rv_new=itemView.findViewById<ImageView>(R.id.community_article_new)
            rv_text.text=item.title
            if(item.recently){

                rv_new.visibility=View.VISIBLE
            }else{
                rv_new.visibility=View.INVISIBLE
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.commuity_rvitem,parent,false)
        // 뷰 홀더에 뷰 넣어주기
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
        if(itemClick!=null){
            holder.itemView.setOnClickListener{v->
                itemClick?.onClick(v,position)

            }
        }

    }

    override fun getItemCount(): Int {
        return items.size; // 아이템 7개로 제한
    }
}