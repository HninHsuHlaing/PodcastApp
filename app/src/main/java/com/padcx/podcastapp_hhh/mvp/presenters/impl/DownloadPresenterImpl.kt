package com.padcx.podcastapp_hhh.mvp.presenters.impl

import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.mvp.presenters.DownloadPresenter
import com.padcx.podcastapp_hhh.mvp.views.DownloadView
import com.padcx.shared.presenter.AbstractBasePresenter

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
class DownloadPresenterImpl : DownloadPresenter, AbstractBasePresenter<DownloadView>() {
    override fun onUiReady() {
        mView?.show_all_downloaded_podcast()
    }

    override fun OnTapDownloadItem(dataVO: DataVO) {
        mView?.navigate_to_Detail_Podcast(dataVO.data_id)
    }

    override fun onTapPodCast_Item(itemVO: ItemVO) {
        mView?.navigate_to_Detail_Podcast(itemVO.id.toString())
    }

    override fun onTapDownload(itemVO: ItemVO) {

    }
}