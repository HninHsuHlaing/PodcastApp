package com.padcx.podcastapp_hhh.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.podcastapp_hhh.mvp.views.SearchView
import com.padcx.shared.presenter.BasePresenter

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
interface SearchPresenter :BasePresenter<SearchView>{
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
}