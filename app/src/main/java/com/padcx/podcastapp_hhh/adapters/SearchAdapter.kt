package com.padcx.podcastapp_hhh.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.data.vo.GenreVO
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.views.view_holders.SearchHolder
import com.padcx.shared.adapter.SharedBaseAdapter
import com.padcx.shared.viewHolders.SharedBaseViewHolder

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class SearchAdapter: SharedBaseAdapter<SharedBaseViewHolder<GenreVO>, GenreVO>()  {
    var mData : MutableList<GenreVO> = arrayListOf()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.categories_item,parent,false)
        return SearchHolder(view)
    }

//    override fun getItemCount(): Int {
//        return mData.size
//    }
//
//    override fun onBindViewHolder(holder: SearchHolder, position: Int) {
//        mData.get(position).let {
//        holder.bindData(mData[position])
//        }
//
//    }
    fun setNewsData(data : List<GenreVO>){
        mData.clear()
        mData = data.toMutableList()
        notifyDataSetChanged()
    }


}