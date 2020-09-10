package com.padcx.podcastapp_hhh.mvp.presenters.impl

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.podcastapp_hhh.data.model.PodcastModel
import com.padcx.podcastapp_hhh.data.model.PodcastModelImpl
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
    var mPodcastModel: PodcastModel = PodcastModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner) {
    mPodcastModel.getAllDownload().observe(lifecycleOwner, Observer {
        it.let {
        mView?.show_all_downloaded_podcast(it)
        }
    })

    }

    override fun OnTapDownloadItem(dataVO: DataVO) {
        mView?.navigate_to_Detail_Podcast(dataVO.data_id)
    }

    override fun onTapPodCast_Item(podcastid: String) {
        mView?.navigate_to_Detail_Podcast(podcastid)
    }

    override fun onTapDownload(itemVO: ItemVO) {

    }

    override fun onTapFindSomethingNew() {
        Log.d("Tap Find Button","On Tap the FInd item on Download page")
    }

    override fun onTapReload() {
       Log.d("Tap Reload Button","On Tap Reload Button on Download page")
    }
}