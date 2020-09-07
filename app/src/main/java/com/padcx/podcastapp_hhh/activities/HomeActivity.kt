package com.padcx.podcastapp_hhh.activities

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.adapters.FragmentAdapter
import com.padcx.podcastapp_hhh.fragments.DownloadFragment
import com.padcx.podcastapp_hhh.fragments.HomeFragment
import com.padcx.podcastapp_hhh.fragments.SearchFragment
import com.padcx.shared.activities.BaseActivity
import kotlinx.android.synthetic.main.home_activity.*


class HomeActivity : BaseActivity()
    ,HomeFragment.OnFragmentInteractionListener,SearchFragment.OnFragmentInteractionListener
,DownloadFragment.OnFragmentInteractionListener{

    val fragment1: Fragment = HomeFragment()
    val fragment2: Fragment = SearchFragment()
    val fragment3: Fragment = DownloadFragment()
    val fm: FragmentManager = supportFragmentManager
    var active: Fragment = fragment1
    companion object{
        fun newIntent(context: Context):Intent{
            val intent =  Intent(context, DetailActivity::class.java)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_activity)
        val mFragmentAdapter = FragmentAdapter(this)
            pager2.adapter = mFragmentAdapter

        pager2.currentItem = 0
        pager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback(){
            override fun onPageSelected(position: Int) {
                    when(position){
                        0->{
                            bottom_navigation.selectedItemId = R.id.home_menu
                        }
                        1->{
                            bottom_navigation.selectedItemId = R.id.search_menu
                        }
                        2->{
                            bottom_navigation.selectedItemId = R.id.download_menu
                        }
                        else->{
                            bottom_navigation.selectedItemId = R.id.profile_menu
                        }
                    }
//                1 -> bottom_nevigation.selectedItemId = R.id.profile_mennu
//                2 -> bottom_nevigation.selectedItemId = R.id.notification_menu
            }
        })
        bottom_navigation.setOnNavigationItemSelectedListener ( object : BottomNavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                when (item.itemId) {
                    R.id.home_menu -> {
                        fm.beginTransaction().hide(active).show(fragment1).commit();
                        active = fragment1
                        pager2.currentItem = 0
                        return  true
                    }
                    R.id.search_menu -> {
                        fm.beginTransaction().hide(active).show(fragment2).commit();
                        active = fragment2;
                        pager2.currentItem = 1
                        return  true
                    }
                    R.id.download_menu -> {
                        fm.beginTransaction().hide(active).show(fragment3).commit();
                        active = fragment3;
                        pager2.currentItem = 2
                        return  true
                    }
                    R.id.profile_menu -> {
                        pager2.currentItem = 0
                        return  true
                    }

                }
                return  true
            }
        })

      //  bottom_navigation.



     //   setUpRecycler()


        }



    override fun onFragmentInteraction(uri: Uri) {
        TODO("Not yet implemented")
    }


//        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.home))
//        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.search))
//        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.download))
//        tablayout.addTab(tablayout.newTab().setIcon(R.drawable.profile))
       // tablayout.getTabAt(0)?.setIcon(R.drawable.home)
//        tablayout.getTabAt(1)?.setIcon(R.drawable.search)
//        tablayout.getTabAt(2)?.setIcon(R.drawable.download)
//        tablayout.getTabAt(3)?.setIcon(R.drawable.profile)

    }


