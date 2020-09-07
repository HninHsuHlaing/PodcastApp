package com.padcx.podcastapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.delegates.DownloadDelagate
import com.padcx.podcastapp_hhh.views.view_holders.DownloadHolder

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
    fun setNewsData(data : List<DataVO>){
        mData.clear()
        mData = data.toMutableList()
        notifyDataSetChanged()
    }


}