package com.padcx.shared.adapter

import androidx.recyclerview.widget.RecyclerView
import com.padcx.shared.viewHolders.SharedBaseViewHolder

/**
 * Created by Hnin Hsu Hlaing
 * on 8/30/2020
 */
abstract class BaseAdapter<T> : RecyclerView.Adapter<SharedBaseViewHolder>() {


    override fun getItemCount(): Int {
        return 10
    }


}