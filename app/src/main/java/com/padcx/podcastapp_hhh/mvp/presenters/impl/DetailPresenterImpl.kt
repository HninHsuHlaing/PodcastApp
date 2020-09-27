package com.padcx.podcastapp_hhh.mvp.presenters.impl

import android.util.Log
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
     //   mPodcastModel.save_detailPodcast(pid)
        requestData(pid)
//        mPodcastModel.get_DetailPodcast(pid).observe(lifecycleOwner, Observer {
//          it?.let {
//            //  Log.d("Detail",it.toString())
//              mView?.showDetailPodcast(it)
//          }
//        })

        mPodcastModel.getDetail(podcastID = pid,onSuccess = {
            mView?.showDetailPodcast(it)
        },
        onFialure = {
            Log.d("DetailError",it)
        })

    }

    override fun onTouchPlayPause(mAudioUri: String) {
        mView?.onTouchPlayPauseIcon(mAudioUri)
    }

    override fun onTouchFifteenSec() {
        mView?.onTouchBackwardFifteenSecIcon()
    }

    override fun onTouchThirtySec() {
        mView?.onTouchForwardThirtySecIcon()
    }

    private fun requestData(pid:String){

        mPodcastModel.save_detailPodcast(pid)
    }

}