package com.padcx.podcastapp_hhh.mvp.presenters.impl

import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.podcastapp_hhh.data.model.PodcastModel
import com.padcx.podcastapp_hhh.data.model.PodcastModelImpl
import com.padcx.podcastapp_hhh.mvp.presenters.DetailPresenter
import com.padcx.podcastapp_hhh.mvp.views.DetailView
import com.padcx.shared.presenter.AbstractBasePresenter

/**
 * Created by Hnin Hsu Hlaing
 * on 9/4/2020
 */
class DetailPresenterImpl :DetailPresenter, AbstractBasePresenter<DetailView>() {
    var mPodcastModel: PodcastModel = PodcastModelImpl
    override fun onUiReady(lifecycleOwner: LifecycleOwner, pid: String) {
        mPodcastModel.save_detailPodcast(pid)
        mPodcastModel.get_DetailPodcast(pid).observe(lifecycleOwner, Observer {
            mView?.showDetailPodcast(it)
        })

    }


}