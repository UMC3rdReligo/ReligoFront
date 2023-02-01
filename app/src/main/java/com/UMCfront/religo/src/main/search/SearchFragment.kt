package com.UMCfront.religo.src.main.search

import android.os.Bundle
import android.view.*
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.widget.SearchView

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.community.CommunityFragment
import com.UMCfront.religo.src.main.search.adapter.CourseRVAdapter
import kotlinx.android.synthetic.main.fragment_search.*


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
        var result = arguments?.getString("key")
        val view=inflater.inflate(R.layout.fragment_search, container, false)
        setHasOptionsMenu(true)


        courseRV = view.findViewById(R.id.idRVCourses)


        courseList = ArrayList()

        courseRVAdapter = CourseRVAdapter(courseList)

        courseRV.adapter = courseRVAdapter

        courseList.add(CourseRVModal("교회1", R.drawable.search))
        courseList.add(CourseRVModal("교회2", R.drawable.search))
        courseList.add(CourseRVModal("교회3",R.drawable.search))
        courseList.add(CourseRVModal("교회4", R.drawable.search))
        courseList.add(CourseRVModal("교회5",R.drawable.search))
        courseList.add(CourseRVModal("교회5",R.drawable.search))
        courseList.add(CourseRVModal("교회6",R.drawable.search))
        courseList.add(CourseRVModal("교회7",R.drawable.search))
        courseList.add(CourseRVModal("교회8",R.drawable.search))

        val backtosearch = view.findViewById<ImageView>(R.id.search_back_btn)

        backtosearch.setOnClickListener{
            (activity as MainActivity?)?.changeFragment(SearchHomeFragment.newInstance())
        }


        //SearchHomeFragment에서 받은 값 표시
//        val searchresult = arguments?.getString("searchresult")
//
//
        Toast.makeText(activity, result.toString(), Toast.LENGTH_SHORT).show()









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