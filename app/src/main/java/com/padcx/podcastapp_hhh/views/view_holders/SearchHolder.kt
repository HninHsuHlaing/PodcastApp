package com.padcx.podcastapp_hhh.views.view_holders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.podcastapp_hhh.data.vo.GenreVO
import com.padcx.shared.viewHolders.SharedBaseViewHolder
import kotlinx.android.synthetic.main.categories_item.view.*

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class SearchHolder(itemView: View) : SharedBaseViewHolder<GenreVO>(itemView) {
    override fun bindData(data: GenreVO) {
        mData = data
        data.let {
            itemView.tvCategoriesName.text = data.name
            //itemView.imgcategories
            Glide
                .with(itemView.context)
                .load(data.image)
                .into(itemView.imgcategories)
        }
    }
//    override fun bind_GenreData(data: GenreVO) {
//        mData = data
//        itemView.tvCategoriesName.text = mData!!.name
//    }
//
//    override fun bind_UpnextItemData(data: ItemVO) {
//
//    }

//    fun bindGenreData(data: List<GenreVO>){
//        mData = data
//        itemView.tvCategoriesName.text = mData.name
//    }

}