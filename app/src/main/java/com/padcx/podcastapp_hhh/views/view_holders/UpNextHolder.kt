package com.padcx.podcastapp_hhh.views.view_holders

import android.text.Html
import android.util.Log
import android.view.View
import com.bumptech.glide.Glide
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.delegates.UpNextDelegate
import com.padcx.podcastapp_hhh.firebasee.data.FBDataVO
import com.padcx.podcastapp_hhh.firebasee.data.FBItemVO
import com.padcx.shared.viewHolders.SharedBaseViewHolder
import kotlinx.android.synthetic.main.up_next_item.view.*

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class UpNextHolder(itemView: View,val mDelegate: UpNextDelegate) : SharedBaseViewHolder<FBItemVO>(itemView) {
    init {
        itemView.imgCloudDownload.setOnClickListener {
            mData?.let {
                mDelegate.onTapDownload(it)
            }

        }
        itemView.setOnClickListener {
            mData?.let {
              //mDelegate.onTapPodCast_Item(it.data?.podcast?.itunes_id.toString())
                it.data_id?.let { it1 -> mDelegate.onTapPodCast_Item(it1) }
            }
        }
    }

    override fun bindData(data: FBItemVO) {
        mData = data
        itemView.tvTitle.text = data.type
        data.type?.let { Log.d("Episode Type ", it) }
       // itemView.tvTitle.text = data.data.podcast.type
        itemView.tvshowDescription.text = Html.fromHtml(data.description)
       // data.data?.title?.let { Log.d("episode Title ", it) }
        Glide
            .with(itemView.context)
            .load(data.image)
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