package com.UMCfront.religo.src.main.event

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.MainActivity
import com.UMCfront.religo.src.main.home.HomeFragment
import com.UMCfront.religo.src.main.home.adapter.HomeViewPagerAdapter
import kotlinx.android.synthetic.main.fragment_event.*
import kotlinx.android.synthetic.main.fragment_search.*




class EventFragment : Fragment() {

    val myEventList= mutableListOf<MyEventItem>()
    val eventItemDetailList = mutableListOf<EventItemDetail>()






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view=inflater.inflate(R.layout.fragment_event, container, false)

        val viewPager2Event = view.findViewById<ViewPager2>(R.id.viewpager_myevent)


        eventItemDetailList.add(EventItemDetail("교회1","장소1","날짜1", R.drawable.calendar))
        eventItemDetailList.add(EventItemDetail("교회2","장소2","날짜2", R.drawable.calendar))
        eventItemDetailList.add(EventItemDetail("교회3","장소3","날짜3", R.drawable.calendar))
        eventItemDetailList.add(EventItemDetail("교회4","장소4","날짜4", R.drawable.calendar))


//        for(i in 0..eventItemDetailList.size-2 step 2){
//            eventItemDetailList.add(
//                EventFragment.MyEventItem(
//                    eventItemDetailList.get(i),
//                    eventItemDetailList.get(i + 1)
//                )
//            )
//
//        }

        val eventVPA = EventViewPagerAdapter(myEventList)



        val eventViewPagerAdapter= EventViewPagerAdapter(myEventList)
        viewPager2Event.adapter= eventViewPagerAdapter
        // 더 알아보기 클릭

        eventViewPagerAdapter.EventItemClick1=object : EventViewPagerAdapter.EventViewMoreItemClick{
            override fun onClick(view: View, position: Int) {
                (activity as MainActivity?)?.changeFragment(EventDetailFragment())
            }
        }

        eventViewPagerAdapter.EventItemClick2=object : EventViewPagerAdapter.EventViewMoreItemClick{
            override fun onClick(view: View, position: Int) {
                (activity as MainActivity?)?.changeFragment(EventDetailFragment())
            }
        }





        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    //  view pager 객체 지정

    inner class MyEventItem constructor(event1: EventItemDetail, event2: EventItemDetail){


        lateinit var event1: EventItemDetail
        lateinit var event2: EventItemDetail

        init{
            this.event1=event1
            this.event2=event2

        }

    }

    inner class EventItemDetail constructor(name:String,location:String,date:String,mainImg:Int){
        var name:String=""
        var location:String=""
        var date:String=""
        var mainImg:Int
        init{
            this.name=name;
            this.location=location;
            this.date=date;
            this.mainImg=mainImg
        }
    }



    companion object {
        fun newInstance(): EventFragment {
            return EventFragment()
        }
    }
}