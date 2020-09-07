package com.padcx.podcastapp_hhh.views.view_holders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.delegates.DownloadDelagate
import com.padcx.shared.viewHolders.SharedBaseViewHolder
import kotlinx.android.synthetic.main.download_item.view.*

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
            Glide
                .with(itemView.context)
                .load(data.image)
                .into(itemView.imgDetailPodcast)
        }
    }

}