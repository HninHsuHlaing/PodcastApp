package com.padcx.podcastapp_hhh.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padcx.podcastapp_hhh.fragments.Download_fragment
import com.padcx.podcastapp_hhh.fragments.Home_Fragment
import com.padcx.podcastapp_hhh.fragments.Search_fragment

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class Fragment_Adapter (fm :FragmentActivity) :FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
      when(position){
          0->{
              return Home_Fragment.newInstance()
          }
          1->{
              return Search_fragment.newInstance()
          }
          2->{
              return Download_fragment.newInstance()
          }
            else ->{
                return Home_Fragment.newInstance()
            }

      }
    }

}