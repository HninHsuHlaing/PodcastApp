package com.padcx.podcastapp_hhh.mvp.views

import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse
import com.padcx.shared.view.BaseView

/**
 * Created by Hnin Hsu Hlaing
 * on 9/4/2020
 */
interface DetailView  :BaseView{
    fun showDetailPodcast(detailResponse: GetDetailResponse)
}