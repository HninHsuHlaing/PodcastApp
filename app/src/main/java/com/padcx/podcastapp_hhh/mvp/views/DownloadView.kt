package com.padcx.podcastapp_hhh.mvp.views

import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.shared.view.BaseView

/**
 * Created by Hnin Hsu Hlaing
 * on 8/30/2020
 */
interface DownloadView : BaseView {
    fun show_all_downloaded_podcast(dataVO: List<DataVO>)
    fun navigate_to_Detail_Podcast(id:String)
}