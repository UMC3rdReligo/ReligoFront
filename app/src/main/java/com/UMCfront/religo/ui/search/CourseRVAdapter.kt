package com.UMCfront.religo.ui.search


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import kotlinx.coroutines.NonDisposableHandle.parent
import android.content.Intent as Intent


class CourseRVAdapter(
    private var courseList: ArrayList<CourseRVModal>
) : RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseRVAdapter.CourseViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(
            R.layout.course_rv_item,
            parent, false
        )
        return CourseViewHolder(itemView)
    }


    fun filterList(filterlist: ArrayList<CourseRVModal>) {
        courseList = filterlist
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CourseRVAdapter.CourseViewHolder, position: Int) {
        holder.courseNameTV.text = courseList.get(position).courseName
        holder.courseIV.setImageResource(courseList.get(position).courseImg)
    }

    override fun getItemCount(): Int {
        return courseList.size
    }

    class CourseViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseNameTV: TextView = itemView.findViewById(R.id.idTVCourse)
        val courseIV: ImageView = itemView.findViewById(R.id.idIVImage)
        val cardView: CardView = itemView.findViewById(R.id.cardview_body)

//        fun bind(item: CourseRVModal){
//            courseNameTV.text = item.courseName
//            courseIV. = item.courseImg
//            itemView.setOnClickListener{
//                Intent(this, DetailActivity::class.java)
//            }        }





    }


}
