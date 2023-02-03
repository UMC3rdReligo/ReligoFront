package com.UMCfront.religo.src.main.home.adapter

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
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions

class HomeViewPagerAdapter(val items:MutableList<HomeFragment.HomeChurchViewItem>): RecyclerView.Adapter<HomeViewPagerAdapter.ViewHolder>() {

    // 더 알아보기 클릭
    interface ChurchViewMoreItemClick{
        fun onClick(view:View,position:Int)
    }

    var churchItemClick1: ChurchViewMoreItemClick?=null
    var churchItemClick2: ChurchViewMoreItemClick?=null


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        fun bindItem(item: HomeFragment.HomeChurchViewItem){
            val rv_text1=itemView.findViewById<TextView>(R.id.home_church_item1_text)
            val rv_text2=itemView.findViewById<TextView>(R.id.home_church_item2_text)
            val rv_address1=itemView.findViewById<TextView>(R.id.home_church_item1_location)
            val rv_address2=itemView.findViewById<TextView>(R.id.home_church_item2_location)
            val rv_img1=itemView.findViewById<ImageView>(R.id.home_church_item1_img)
            val rv_img2=itemView.findViewById<ImageView>(R.id.home_church_item2_img)
            rv_text1.text=item.church1.name
            rv_text2.text=item.church2.name
            rv_address1.text=item.church1.address
            rv_address2.text=item.church2.address
            //glide에서 호출
            Glide.with(itemView.context)
                .load(item.church1.mainImg) // 불러올 이미지 url
                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .error(rv_img1) // 로딩 에러 발생 시 표시할 이미지
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(500,300)
                .into(rv_img1) // 이미지를 넣을 뷰

            Glide.with(itemView.context)
                .load(item.church2.mainImg) // 불러올 이미지 url
                .apply(RequestOptions.bitmapTransform(RoundedCorners(14)))
                .error(rv_img2) // 로딩 에러 발생 시 표시할 이미지
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE)
                .override(500,300)
                .into(rv_img2) // 이미지를 넣을 뷰

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.home_viewpager_church_item,parent,false)
        // 뷰 홀더에 뷰 넣어주기
        return ViewHolder(view)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(items[position])
        if(churchItemClick1!=null){
            holder.itemView.findViewById<ImageView>(R.id.home_church_item1_view_more).setOnClickListener{v->
                churchItemClick1?.onClick(v,position)

            }
        }

        if(churchItemClick2!=null){
            holder.itemView.findViewById<ImageView>(R.id.home_church_item2_view_more).setOnClickListener{v->
                churchItemClick2?.onClick(v,position)

            }
        }
    }

    override fun getItemCount(): Int {
        return items.size;
    }
}