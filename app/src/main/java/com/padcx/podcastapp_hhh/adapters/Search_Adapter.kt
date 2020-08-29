package com.padcx.podcastapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.view_holders.Search_Holder

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class Search_Adapter: RecyclerView.Adapter<Search_Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Search_Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_item,parent,false)
        return Search_Holder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: Search_Holder, position: Int) {

    }
}