package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.myapplication.ui.main.BlankFragment
import com.example.myapplication.ui.main.BlankFragment2
import com.example.myapplication.ui.main.BlankFragment3
import com.example.myapplication.ui.main.otheractivty
import kotlinx.android.synthetic.main.activity_mypage.*
import java.io.IOException
import java.io.InputStream
import kotlin.system.exitProcess


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager: ViewPager = findViewById(R.id.view_pager)

        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val viewPagerAdapter= viewpage(supportFragmentManager)
        viewPagerAdapter.addFragments(BlankFragment3(),"الغاء")
        viewPagerAdapter.addFragments(BlankFragment2(),"تم القبول")
        viewPagerAdapter.addFragments(BlankFragment(),"قيد الانتظار")
        viewPager.adapter=viewPagerAdapter
        tabs.setupWithViewPager(viewPager)


        val myPagerAdapter= viewpage(supportFragmentManager)




    }


    internal class viewpage(fragmentManager: FragmentManager) :
        FragmentPagerAdapter(fragmentManager) {
        private val fragments: ArrayList<Fragment>
        private val titels: ArrayList<String>

        init {
            fragments= ArrayList<Fragment>()
            titels= ArrayList<String>()
        }

        override fun getItem(position: Int): Fragment {
            return fragments[position]
        }

        override fun getCount(): Int {
            return fragments.size
        }
        fun addFragments(fragment: Fragment, titel:String){
            fragments.add(fragment)
            titels.add(titel)
        }

        override fun getPageTitle(i: Int): CharSequence? {
            return titels[i]
        }
    }
    fun exit(view: View){
        exitProcess(-1)
    }
    fun addpage(view: View) {
        val change =  Intent (this, addpage::class.java)
        startActivity(change)
    }
    fun mypage(view: View) {
        val change =  Intent (this, mypage::class.java)
        startActivity(change)
    }
    fun otherpage(view: View) {
        val other =  Intent (this, otheractivty::class.java)
        startActivity(other)
    }

}