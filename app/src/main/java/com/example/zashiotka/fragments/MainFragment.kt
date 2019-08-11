package com.example.zashiotka.fragments

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.example.zashiotka.R

class MainFragment : AppCompatActivity() {

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_add_function -> {
                replaceFragment(CreateActivityFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_search_function -> {
                replaceFragment(SearchActivityFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_home_window -> {
                replaceFragment(HomeActivityFragment.newInstance())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        replaceFragment(HomeActivityFragment.newInstance())
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
    }


    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragmentHolder, fragment)
            .commit()

    }
}
