package com.padcx.podcastapp_hhh.mvp.views

import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO
import com.padcx.podcastapp_hhh.firebasee.data.FBDataVO
import com.padcx.podcastapp_hhh.firebasee.data.FBItemVO
import com.padcx.podcastapp_hhh.firebasee.data.FBRandomPodcastVO
import com.padcx.podcastapp_hhh.network.dataResponse.RandomPodcstResponse
import com.padcx.shared.view.BaseView

/**
 * Created by Hnin Hsu Hlaing
 * on 8/26/2020
 */
interface UpNextView  : BaseView {
    fun bind_Random_Podcast(podcast : List<FBRandomPodcastVO>)
    fun show_all_podcast(latestpodCastList: List<FBItemVO>)
    fun navigate_to_Podcast_Detail(id: String)
  //  fun downloadPodcast()
    fun checkPermission(itemVO: FBItemVO)

    fun onTouchPlayPauseImage(audioUrl : String)
    fun onTouchForwardThirtySecIcon()
    fun onTouchBackwardFifteenSecIcon()
}