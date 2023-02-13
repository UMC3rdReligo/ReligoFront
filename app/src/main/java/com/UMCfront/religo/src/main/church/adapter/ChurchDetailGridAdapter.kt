package com.UMCfront.religo.src.main.church.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R

class ChurchDetailGridAdapter(val items:MutableList<String>): RecyclerView.Adapter<ChurchDetailGridAdapter.ViewHolder>() {

    interface GridItemClick{
        fun onClick(view: View, position:Int)
    }

    var itemClick: ChurchDetailGridAdapter.GridItemClick?=null
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        //아이템 클릭

        fun bindItem(item:String){
            val rv_text_title=itemView.findViewById<TextView>(R.id.home_review_rv_detail_title)
            rv_text_title.text=item

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.home_review_rv_item_grid,parent,false)
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