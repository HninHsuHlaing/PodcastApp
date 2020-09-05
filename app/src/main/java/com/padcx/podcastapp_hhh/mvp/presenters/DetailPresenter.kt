package com.padcx.podcastapp_hhh.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.podcastapp_hhh.mvp.views.DetailView
import com.padcx.shared.presenter.BasePresenter

interface DetailPresenter : BasePresenter<DetailView> {
    fun onUiReady(lifecycleOwner: LifecycleOwner,pid:String)
}