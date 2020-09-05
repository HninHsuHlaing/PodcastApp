package com.padcx.podcastapp_hhh.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.padcx.podcastapp_hhh.fragments.DownloadFragment
import com.padcx.podcastapp_hhh.fragments.HomeFragment
import com.padcx.podcastapp_hhh.fragments.SearchFragment

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class FragmentAdapter (fm :FragmentActivity) :FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return 4
    }

    override fun createFragment(position: Int): Fragment {
      when(position){
          0->{
              return HomeFragment.newInstance()
          }
          1->{
              return SearchFragment.newInstance()
          }
          2->{
              return DownloadFragment.newInstance()
          }
            else ->{
                return HomeFragment.newInstance()
            }

      }
    }

}