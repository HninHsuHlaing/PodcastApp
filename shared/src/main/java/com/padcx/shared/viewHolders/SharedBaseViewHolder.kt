package com.padcx.shared.viewHolders

import android.view.View
import androidx.recyclerview.widget.RecyclerView

/**
 * Created by Hnin Hsu Hlaing
 * on 8/30/2020
 */
abstract class SharedBaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView){
    var mData : T? = null
    abstract fun bindData(data: T)


}