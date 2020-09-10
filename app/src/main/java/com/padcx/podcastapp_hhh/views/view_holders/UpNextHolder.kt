package com.padcx.podcastapp_hhh.views.view_holders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.delegates.UpNextDelegate
import com.padcx.shared.viewHolders.SharedBaseViewHolder
import kotlinx.android.synthetic.main.up_next_item.view.*

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class UpNextHolder(itemView: View,val mDelegate: UpNextDelegate) : SharedBaseViewHolder<ItemVO>(itemView) {
    init {
        itemView.imgCloudDownload.setOnClickListener {
            mData?.let {
                mDelegate.onTapDownload(it)
            }

        }
        itemView.setOnClickListener {
            mData?.let {
                mDelegate.onTapPodCast_Item(it.data.data_id)
            }
        }
    }

    override fun bindData(data: ItemVO) {
        mData = data
        itemView.tvTitle.text = data.type
       // itemView.tvTitle.text = data.data.podcast.type
        itemView.tvshowDescription.text = data.data.title
        Glide
            .with(itemView.context)
            .load(data.data.image)
            .into(itemView.imgUpNext)

//    override fun bind_GenreData(data: GenreVO) {
//
//    }
//
//    override fun bind_UpnextItemData(item: ItemVO) {
//       itemView.tvshowDescription.text = item.data.title
//    }


    }
}