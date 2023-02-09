package com.UMCfront.religo.src.main.event

import android.view.LayoutInflater
import android.view.RoundedCorner
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.community.adapter.CommunityRVAdapter1
import com.UMCfront.religo.src.main.home.HomeFragment
import com.UMCfront.religo.src.main.home.adapter.HomeViewPagerAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class EventViewPagerAdapter(val items:MutableList<EventFragment.MyEventItem>): RecyclerView.Adapter<EventViewPagerAdapter.ViewHolder>() {

    // 더 알아보기 클릭
    interface EventViewMoreItemClick{
        fun onClick(view:View,position:Int)
    }

    var EventItemClick1: EventViewMoreItemClick?=null
    var EventItemClick2: EventViewMoreItemClick?=null


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: EventFragment.MyEventItem){
            val rv_text1=itemView.findViewById<TextView>(R.id.event_item_text1)
            val rv_text2=itemView.findViewById<TextView>(R.id.event_item_text2)
            val rv_date1=itemView.findViewById<TextView>(R.id.event_item_date)
            val rv_date2=itemView.findViewById<TextView>(R.id.event_item2_date)
            val rv_location1=itemView.findViewById<TextView>(R.id.home_church_item1_location)
            val rv_location2=itemView.findViewById<TextView>(R.id.home_church_item2_location)
            val rv_img1=itemView.findViewById<ImageView>(R.id.event_item_img1)
            val rv_img2=itemView.findViewById<ImageView>(R.id.event_item2_img)
            rv_text1.text=item.event1.name
            rv_text2.text=item.event2.name
            rv_date1.text=item.event1.date
            rv_date2.text=item.event2.date
            rv_location1.text=item.event1.location
            rv_location2.text=item.event2.location

            //glide에서 호출
            Glide.with(itemView.context)
                .load(item.event1.mainImg) // 불러올 이미지 url
                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .error(rv_img1) // 로딩 에러 발생 시 표시할 이미지
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(500,300)
                .into(rv_img1) // 이미지를 넣을 뷰

            Glide.with(itemView.context)
                .load(item.event2.mainImg) // 불러올 이미지 url
                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .error(rv_img2) // 로딩 에러 발생 시 표시할 이미지
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(500,300)
                .into(rv_img2) // 이미지를 넣을 뷰

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.event_viewpager_item,parent,false)
        // 뷰 홀더에 뷰 넣어주기
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
        if(EventItemClick1!=null){
            holder.itemView.findViewById<ImageView>(R.id.home_church_item1_view_more).setOnClickListener{v->
                EventItemClick1?.onClick(v,position)

            }
        }

        if(EventItemClick2!=null){
            holder.itemView.findViewById<ImageView>(R.id.home_church_item2_view_more).setOnClickListener{v->
                EventItemClick2?.onClick(v,position)

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size;
    }
}