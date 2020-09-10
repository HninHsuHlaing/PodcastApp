package com.padcx.podcastapp_hhh.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.podcastapp_hhh.delegates.DownloadDelagate
import com.padcx.podcastapp_hhh.delegates.UpNextDelegate
import com.padcx.podcastapp_hhh.mvp.views.DownloadView
import com.padcx.podcastapp_hhh.views.viewPod.EmptyViewPod
import com.padcx.shared.presenter.BasePresenter

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
interface DownloadPresenter :BasePresenter<DownloadView>,DownloadDelagate,UpNextDelegate,
    EmptyViewPod.Delegate{
    fun onUiReady(lifecycleOwner: LifecycleOwner)
}