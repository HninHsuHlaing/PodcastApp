package com.padcx.podcastapp_hhh.mvp.presenters

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.delegates.UpNextDelegate
import com.padcx.podcastapp_hhh.mvp.views.UpNextView
import com.padcx.shared.presenter.BasePresenter
import com.padcx.shared.view.BaseView

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
interface HomePresenter :BasePresenter<UpNextView> ,UpNextDelegate{
    fun onUiReady(lifeCycleOwner: LifecycleOwner)
    fun download(context: Context, itemVO: ItemVO) : Long
    fun saveDownload(dataVO: DataVO)

}