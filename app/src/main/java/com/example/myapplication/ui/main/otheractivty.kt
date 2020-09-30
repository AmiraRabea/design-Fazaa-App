package com.example.myapplication.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.mypage
import kotlin.system.exitProcess


class otheractivty : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otheractivty)

        val viewPager: ViewPager = findViewById(R.id.view_pager)

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val viewPagerAdapter = MainActivity.viewpage(supportFragmentManager)
        viewPagerAdapter.addFragments(BlankFragment3(), "الغاء")
        viewPagerAdapter.addFragments(BlankFragment2(), "تم القبول")
        viewPagerAdapter.addFragments(BlankFragment(), "قيد الانتظار")
        viewPager.adapter = viewPagerAdapter
        tabs.setupWithViewPager(viewPager)

    }

    @Suppress("DEPRECATION")
    internal class viewpage(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager) {

        private val fragments: ArrayList<Fragment>
        private val titels: ArrayList<String>

        init {
            fragments = ArrayList<Fragment>()
            titels = ArrayList<String>()
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }

        fun addFragments(fragment: Fragment, titel: String) {
            fragments.add(fragment)
            titels.add(titel)
        }

        override fun getPageTitle(i: Int): CharSequence? {
            return titels[i]
        }

    }
}