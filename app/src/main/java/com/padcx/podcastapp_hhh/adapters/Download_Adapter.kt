package com.padcx.podcastapp_hhh.adapters

import android.view.LayoutInflater
import android.view.TouchDelegate
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.delegates.Up_next_Delegate
import com.padcx.podcastapp_hhh.view_holders.Download_Holder

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class Download_Adapter(val delegate: Up_next_Delegate) : RecyclerView.Adapter<Download_Holder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Download_Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.up_next_item,parent,false)
        return Download_Holder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: Download_Holder, position: Int) {
        holder.itemView.setOnClickListener {
            delegate.onTapPodCast_Item()
        }
    }
}