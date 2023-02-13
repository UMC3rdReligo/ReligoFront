package com.UMCfront.religo.src.main.community.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.community.CommunityChurchFragment

class CommunityAdapterChruch(val items:MutableList<CommunityChurchFragment.CommunityChurchDetail>):RecyclerView.Adapter<CommunityAdapterChruch.ViewHolder>() {

    interface GridItemClick{
        fun onClick(view:View,position:Int)
    }

    var itemClick: CommunityAdapterChruch.GridItemClick?=null
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        //아이템 클릭

        fun bindItem(item: CommunityChurchFragment.CommunityChurchDetail){
            val rv_text_title=itemView.findViewById<TextView>(R.id.community_rv_detail_title)
            val rv_text=itemView.findViewById<TextView>(R.id.community_rv_detail_text)
            val rv_heartCount=itemView.findViewById<TextView>(R.id.community_rv_heart_cnt)

            rv_text_title.text=item.title.toString()
            rv_text.text=item.text.toString()
            rv_heartCount.text=item.hearCount.toString()
            Log.d("ttt",rv_text_title.toString())


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.community_rv_item_grid,parent,false)
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