package com.UMCfront.religo.src.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.community.adapter.CommunityCommentRVAdapter

class HomeReviewRVAdapter(val items:MutableList<String>) {

    // 아이템 클릭

    // dddd
    interface ItemClick{
        fun onClick(view:View,position:Int)
    }

    var itemClick:ItemClick?=null

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItem(item:String){
            val rv_text=itemView.findViewById<TextView>(R.id.community_rv_text)
            rv_text.text=item

        }

    }

    fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.home_review_rv_item,parent,false)
        // 뷰 홀더에 뷰 넣어주기
        return ViewHolder(view)

    }

    fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
        if(itemClick!=null){
            holder.itemView.setOnClickListener{v->
                itemClick?.onClick(v,position)

            }
        }

    }

    fun getItemCount(): Int {
        return items.size; // 아이템 7개로 제한
    }


}