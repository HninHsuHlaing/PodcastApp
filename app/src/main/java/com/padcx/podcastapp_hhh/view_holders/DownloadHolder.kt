package com.padcx.podcastapp_hhh.view_holders

import android.view.View
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.delegates.DownloadDelagate
import com.padcx.podcastapp_hhh.delegates.UpNextDelegate
import com.padcx.shared.viewHolders.SharedBaseViewHolder

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class DownloadHolder(itemView: View,val mDelegate: DownloadDelagate) : SharedBaseViewHolder<DataVO>(itemView) {
    init {

        itemView.setOnClickListener {
           mData?.let {
               mDelegate.OnTapDownloadItem(it)
           }
        }
    }

    override fun bindData(data: DataVO) {
        mData = data
        data.let {

        }
    }

}