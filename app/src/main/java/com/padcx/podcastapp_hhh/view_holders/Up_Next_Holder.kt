package com.padcx.podcastapp_hhh.view_holders

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.padcx.podcastapp_hhh.delegates.Up_next_Delegate

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class Up_Next_Holder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    init {
        itemView.setOnClickListener {
       // delegate.onTapPodCast_Item()
        }
    }
}