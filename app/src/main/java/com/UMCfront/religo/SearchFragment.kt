package com.UMCfront.religo

import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.databinding.DataBindingUtil.setContentView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.cardview_search.CourseRVAdapter
import com.example.cardview_search.CourseRVModal


class SearchFragment : Fragment() {


//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        // Inflate the layout for this fragment
//        return inflater.inflate(R.layout.fragment_search, container, false)
//    }
//
    companion object {
        fun newInstance(): SearchFragment {
            return SearchFragment()
        }
    }

    lateinit var courseRV: RecyclerView
    lateinit var courseRVAdapter: CourseRVAdapter
    lateinit var courseList: ArrayList<CourseRVModal>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):View? {
        val view=inflater.inflate(R.layout.fragment_search, container, false)
        setHasOptionsMenu(true)


        courseRV = view.findViewById(R.id.idRVCourses)


        courseList = ArrayList()

        courseRVAdapter = CourseRVAdapter(courseList)

        courseRV.adapter = courseRVAdapter

        courseList.add(CourseRVModal("교회1", R.drawable.ic_launcher_background))
        courseList.add(CourseRVModal("교회2", R.drawable.ic_launcher_background))
        courseList.add(CourseRVModal("교회3", R.drawable.ic_launcher_background))
        courseList.add(CourseRVModal("교회4", R.drawable.ic_launcher_background))
        courseList.add(CourseRVModal("교회5",R.drawable.ic_launcher_background))
        courseList.add(CourseRVModal("교회5",R.drawable.ic_launcher_background))
        courseList.add(CourseRVModal("교회6",R.drawable.ic_launcher_background))
        courseList.add(CourseRVModal("교회7",R.drawable.ic_launcher_background))
        courseList.add(CourseRVModal("교회8",R.drawable.ic_launcher_background))



        courseRVAdapter.notifyDataSetChanged()
        return view


    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater){


        inflater.inflate(R.menu.search_menu, menu)

        val searchItem: MenuItem = menu.findItem(R.id.actionSearch)

        val searchView: SearchView = searchItem.getActionView() as SearchView

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(msg: String): Boolean {
                filter(msg)
                return false
            }
        })

    }

    private fun filter(text: String) {
        val filteredlist: ArrayList<CourseRVModal> = ArrayList()

        for (item in courseList) {
            if (item.courseName.toLowerCase().contains(text.toLowerCase())) {
                filteredlist.add(item)
            }
        }
//        if (filteredlist.isEmpty()) {
//            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show()
//        } else {
//            courseRVAdapter.filterList(filteredlist)
//        }
    }


}