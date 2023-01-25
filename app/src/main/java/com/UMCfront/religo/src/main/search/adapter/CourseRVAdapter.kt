package com.UMCfront.religo.src.main.search.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.search.CourseRVModal


class CourseRVAdapter(
    private var courseList: ArrayList<CourseRVModal>
) : RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CourseViewHolder {
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

    override fun onBindViewHolder(holder: CourseViewHolder, position: Int) {
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
