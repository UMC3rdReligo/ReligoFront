package com.UMCfront.religo.src.main.mypage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.church.adapter.ChurchDetailGridAdapter

class MypageMychurchAdapter(val items:MutableList<String>): RecyclerView.Adapter<MypageMychurchAdapter.ViewHolder>() {

    interface GridItemClick{
        fun onClick(view: View, position:Int)
    }

    var itemClick: ChurchDetailGridAdapter.GridItemClick?=null
    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        //아이템 클릭

        fun bindItem(item:String){
            val rv_text_title=itemView.findViewById<TextView>(R.id.mypage_mychurch_churchname_textview)
            rv_text_title.text=item

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.mypage_mychurch_rvitem,parent,false)
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