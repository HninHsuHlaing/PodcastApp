package com.padcx.podcastapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.delegates.DownloadDelagate
import com.padcx.podcastapp_hhh.delegates.UpNextDelegate
import com.padcx.podcastapp_hhh.view_holders.DownloadHolder
import com.padcx.shared.adapter.BaseAdapter
import com.padcx.shared.viewHolders.SharedBaseViewHolder

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class DownloadAdapter(val delegate: DownloadDelagate) : RecyclerView.Adapter<DownloadHolder>() {
    var mData :MutableList<DataVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DownloadHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.download_item,parent,false)
        return DownloadHolder(view,delegate)
    }

    override fun onBindViewHolder(holder: DownloadHolder, position: Int) {
        holder.bindData(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.count()
    }


}