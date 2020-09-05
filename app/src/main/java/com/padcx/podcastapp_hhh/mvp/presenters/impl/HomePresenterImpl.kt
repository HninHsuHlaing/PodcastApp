package com.padcx.podcastapp_hhh.mvp.presenters.impl

import android.content.Context
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.podcastapp_hhh.data.model.PodcastModel
import com.padcx.podcastapp_hhh.data.model.PodcastModelImpl
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.data.vo.ItemVO
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
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        mPodcastModel.getRandomPodcast().observe(lifeCycleOwner, Observer{
           // mView?.play_Random_Podcast("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
            mView?.play_Random_Podcast(it)

        })

        mPodcastModel.getPlayListInfoFromDb().observe(lifeCycleOwner, Observer {
            mView?.show_all_podcast(it)
        })



    }

    override fun download(context: Context, itemVO: ItemVO): Long {
     return   mPodcastModel.downloadPodcast(context,itemVO)
    }

    override fun saveDownload(dataVO: DataVO) {
        mPodcastModel.saveDownloadItem(dataVO)
    }

    override fun onTapPodCast_Item(itemVO: ItemVO) {
        mView?.navigate_to_Podcast_Detail(itemVO.id.toString())
    }

    override fun onTapDownload(itemVO: ItemVO) {
       // mView?.downloadPodcast()
        mView?.checkPermission(itemVO)
    }
}