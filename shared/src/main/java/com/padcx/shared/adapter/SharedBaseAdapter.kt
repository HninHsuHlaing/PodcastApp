package com.padcx.shared.adapter

import androidx.recyclerview.widget.RecyclerView
import com.padcx.shared.viewHolders.SharedBaseViewHolder

/**
 * Created by Hnin Hsu Hlaing
 * on 8/30/2020
 */
abstract class SharedBaseAdapter<T: SharedBaseViewHolder<W>,W> : RecyclerView.Adapter<T>() {

    private var mDataList:MutableList<W> = mutableListOf()

    override fun onBindViewHolder(holder: T, position: Int) {
        holder.bindData(mDataList[position])
    }

    override fun getItemCount(): Int {
        return mDataList.size

    }

    fun setData (data : List<W>){
        mDataList.clear()
        mDataList.addAll(data)
        notifyDataSetChanged()
    }
    fun setNewData(newData: List<W>) {
        if (newData.isEmpty()){
            mDataList.clear()
        }else{
            mDataList = ArrayList(newData)
        }
        notifyDataSetChanged()
    }

}