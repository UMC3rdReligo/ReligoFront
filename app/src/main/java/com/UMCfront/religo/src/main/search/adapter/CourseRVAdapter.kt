package com.UMCfront.religo.src.main.search.adapter


import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.search.CourseRVModal


class CourseRVAdapter(
    var courseList: ArrayList<CourseRVModal>
) : RecyclerView.Adapter<CourseRVAdapter.CourseViewHolder>(), Filterable {

    var TAG = "CourseAdapter"
    var filteredCourse = ArrayList<CourseRVModal>()
    var itemFilter = ItemFilter()

    init {
        filteredCourse.addAll(courseList)
    }

    override fun getFilter(): Filter {
        return itemFilter
    }

    inner class ItemFilter: Filter(){
        //charSequence는 edittext에서 받아온 값이어야함
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val filterString = charSequence.toString()
            val results = FilterResults()

            val filteredList: ArrayList<CourseRVModal> = ArrayList<CourseRVModal>()

            if (filterString.trim{it <= ' '}.isEmpty()){
                results.values = courseList
                results.count = courseList.size

                return results
            }else {
                for (course in courseList){
                    if (course.courseName.contains(filterString)){
                        filteredList.add(course)
                    }
                }

            }
            results.values = filteredList
            results.count = filteredList.size

            return results
        }
        @SuppressLint("NotifyDataSetChanged")
        override fun publishResults(charSequence: CharSequence?, filterResults: FilterResults) {
            filteredCourse.clear()
            filteredCourse.addAll(filterResults.values as ArrayList<CourseRVModal>)
            notifyDataSetChanged()
        }
    }










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
