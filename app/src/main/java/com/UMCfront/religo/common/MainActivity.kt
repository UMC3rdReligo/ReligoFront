package com.UMCfront.religo.common


import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.UMCfront.religo.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    private val fl: FrameLayout by lazy {
        findViewById(R.id.mainFrameLayout)
    }
    private val communityFragment by lazy { CommunityFragment() }

    private val homeFragment by lazy { HomeFragment() }

    private val eventFragment by lazy {EventFragment()}

    private val searchFragment by lazy { SearchFragment() }




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bnv_main=findViewById<BottomNavigationView>(R.id.bottomNavigationView)


        initNavigationBar(bnv_main)


    }

    private fun initNavigationBar(bnv_main:BottomNavigationView) {
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
                        changeFragment(searchFragment)
                    }

                }
                true
            }
            selectedItemId = R.id.nav_home
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFrameLayout, fragment)
            .commit()
    }


}


