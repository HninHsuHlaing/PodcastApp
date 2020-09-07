package com.padcx.podcastapp_hhh.mvp.presenters

import androidx.lifecycle.LifecycleOwner
import com.padcx.podcastapp_hhh.mvp.views.DetailView
import com.padcx.podcastapp_hhh.views.viewPod.MediaPlayer.MiniMusicPlayerViewPod
import com.padcx.shared.presenter.BasePresenter

interface DetailPresenter : BasePresenter<DetailView>, MiniMusicPlayerViewPod.Delegate {
    fun onUiReady(lifecycleOwner: LifecycleOwner,pid:String)
}