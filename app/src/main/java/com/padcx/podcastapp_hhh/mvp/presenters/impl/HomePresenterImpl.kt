package com.padcx.podcastapp_hhh.mvp.presenters.impl

import android.content.Context
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.podcastapp_hhh.data.model.PodcastModel
import com.padcx.podcastapp_hhh.data.model.PodcastModelImpl
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.firebasee.data.FBDataVO
import com.padcx.podcastapp_hhh.firebasee.data.FBItemVO
import com.padcx.podcastapp_hhh.mvp.presenters.HomePresenter
import com.padcx.podcastapp_hhh.mvp.views.UpNextView
import com.padcx.shared.presenter.AbstractBasePresenter
import kotlinx.android.synthetic.main.main_player.*

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
class HomePresenterImpl :HomePresenter, AbstractBasePresenter<UpNextView>() {
    var mPodcastModel: PodcastModel = PodcastModelImpl
//    init{
//        mPodcastModel.getRandomPodcast()
//    }

    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
//        mPodcastModel.getRandomPodcast().observe(lifeCycleOwner, Observer{
//           // mView?.play_Random_Podcast("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
//           // Log.d("Random" ,it.toString())
//            mView?.bind_Random_Podcast(
//                it
//            )
//        })

//        mPodcastModel.getPlayListInfoFromDb().observe(lifeCycleOwner, Observer {
//            mView?.show_all_podcast(it)
//        })

        mPodcastModel.getRandomPodcast(
            onSuccess = {
                mView?.bind_Random_Podcast(it)
            },
            onFaiure = {
                Log.d("RandomPodcast Error",it)
            }
        )
        mPodcastModel.getPlayliat(
            onSuccess = {
                mView?.show_all_podcast(it)
            },onFaiure = {
                Log.d("ErrorPlayist",it)
            }
        )



    }

    override fun download(context: Context, itemVO: FBItemVO): Long {
     return   mPodcastModel.downloadPodcast(context,itemVO)
    }

    override fun saveDownload(dataVO: FBDataVO) {
        mPodcastModel.saveDownloadItem(dataVO)
    }

    override fun onTapPodCast_Item(podcastid: String) {
        mView?.navigate_to_Podcast_Detail(podcastid)
    }

    override fun onTapDownload(itemVO: FBItemVO) {
       // mView?.downloadPodcast()
        mView?.checkPermission(itemVO)
    }

    override fun onTouchPlayPause(audioUrl: String) {
        mView?.onTouchPlayPauseImage(audioUrl)
    }

    override fun onTouchFifteenSec() {
        mView?.onTouchBackwardFifteenSecIcon()
    }

    override fun onTouchThirtySec() {
        mView?.onTouchForwardThirtySecIcon()
    }
}