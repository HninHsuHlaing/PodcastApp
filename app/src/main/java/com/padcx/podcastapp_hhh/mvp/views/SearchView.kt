package com.padcx.podcastapp_hhh.mvp.views

import com.padcx.podcastapp_hhh.data.vo.GenreVO
import com.padcx.shared.view.BaseView

/**
 * Created by Hnin Hsu Hlaing
 * on 8/30/2020
 */
interface SearchView : BaseView {
    fun show_all_caterogries(list: List<GenreVO>)
}