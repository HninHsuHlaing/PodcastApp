package com.padcx.podcastapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.delegates.UpNextDelegate

import com.padcx.podcastapp_hhh.views.view_holders.UpNextHolder
import com.padcx.shared.adapter.SharedBaseAdapter
import com.padcx.shared.viewHolders.SharedBaseViewHolder

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class UpNextAdapter(val delegate: UpNextDelegate) :
    SharedBaseAdapter<SharedBaseViewHolder<ItemVO>, ItemVO>() {
    var mData : MutableList<ItemVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpNextHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.up_next_item,parent,false)
        return UpNextHolder(view,delegate)
    }

    fun setNewsData(data : List<ItemVO>){
        mData.clear()
        mData = data.toMutableList()
        notifyDataSetChanged()
    }
//    override fun getItemCount(): Int {
//          return  mData.size
//    }
//
//    override fun onBindViewHolder(holder: UpNextHolder, position: Int) {
//        mData.get(position).let {
//
//        }
//    }
//    fun setNewsData(data : List<GenreVO>){
//        mData = data
//        notifyDataSetChanged()
//    }


}