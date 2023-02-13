package com.UMCfront.religo.src.main.home.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.home.HomeFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class HomeViewPagerAdapter2(val items:MutableList<HomeFragment.HomeEventDetail>): RecyclerView.Adapter<HomeViewPagerAdapter2.ViewHolder>() {
    interface EventViewMoreItemClick{
        fun onClick(view: View, position:Int)
    }

    var eventItemClick: HomeViewPagerAdapter2.EventViewMoreItemClick?=null


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: HomeFragment.HomeEventDetail){
            val rv_text=itemView.findViewById<TextView>(R.id.home_event_name)
            val rv_address=itemView.findViewById<TextView>(R.id.home_event_location)
            val rv_img=itemView.findViewById<ImageView>(R.id.home_event_image)
            rv_text.text=item.name
            rv_address.text=item.location
            //glide에서 호출
            Glide.with(itemView.context)
                .load(item.mainImg) // 불러올 이미지 url
                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .error(rv_img) // 로딩 에러 발생 시 표시할 이미지
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(500,300)
                .into(rv_img) // 이미지를 넣을 뷰


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.hom_viewpager_event_item,parent,false)
        // 뷰 홀더에 뷰 넣어주기
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
        if(eventItemClick!=null){
            holder.itemView.findViewById<ImageView>(R.id.home_event_viewmore).setOnClickListener{ v->
                eventItemClick?.onClick(v,position)

            }
        }

    }

    override fun getItemCount(): Int {
        return items.size;
    }

}