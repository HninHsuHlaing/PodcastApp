package com.padcx.podcastapp_hhh.views.view_holders

import android.view.View
import com.bumptech.glide.Glide
import com.padcx.podcastapp_hhh.firebasee.data.GenreVOFIreBase
import com.padcx.shared.viewHolders.SharedBaseViewHolder
import kotlinx.android.synthetic.main.categories_item.view.*

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class SearchHolder(itemView: View) : SharedBaseViewHolder<GenreVOFIreBase>(itemView) {
    override fun bindData(data: GenreVOFIreBase) {
        mData = data
        data.let {
            itemView.tvCategoriesName.text = data.name
            //itemView.imgcategories

            Glide
                .with(itemView.context)
                .load(data.image_url)
                .into(itemView.imgcategories)
        }
    }


}