package com.UMCfront.religo.src.main


import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.UMCfront.religo.src.main.community.CommunityFragment
import com.UMCfront.religo.src.main.event.EventFragment
import com.UMCfront.religo.src.main.home.HomeFragment
import com.UMCfront.religo.src.main.mypage.MypageFragment
import com.UMCfront.religo.src.main.search.SearchFragment
import com.UMCfront.religo.src.main.search.SearchHomeFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fl: FrameLayout by lazy {
        findViewById(R.id.mainFrameLayout)
    }

    private val communityFragment by lazy { CommunityFragment() }

    private val homeFragment by lazy { HomeFragment() }

    private val eventFragment by lazy { EventFragment() }

    private val mypageFragment by lazy { MypageFragment() }

    private val searchFragment by lazy { SearchFragment() }

    //SearchHomeFragmnet 테스트화면
    private val searchHomeFragment by lazy { SearchHomeFragment()}




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val bnv_main=findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        initNavigationBar(savedInstanceState,bnv_main)


    }

    private fun initNavigationBar(savedInstanceState: Bundle?,bnv_main:BottomNavigationView) {
        bnv_main.run {
            setOnNavigationItemSelectedListener {
                when(it.itemId) {
                    R.id.nav_group -> {
                        changeFragment(communityFragment)
                    }
                    R.id.nav_home ->{
                        changeFragment(homeFragment)
                    }
                    R.id.nav_celebration ->{
                        changeFragment(eventFragment)
                    }
                    R.id.nav_search ->{
                        changeFragment(searchHomeFragment)
                    }
                    R.id.nav_my ->{
                        changeFragment(mypageFragment)
                    }

                }
                true
            }
            selectedItemId = R.id.nav_home
        }
    }

    fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFrameLayout, fragment)
            .addToBackStack(null)
            .commit()
    }


}


