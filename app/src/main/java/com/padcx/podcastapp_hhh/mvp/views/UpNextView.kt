package com.padcx.podcastapp_hhh.mvp.views

import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO
import com.padcx.podcastapp_hhh.network.dataResponse.RandomPodcstResponse
import com.padcx.shared.view.BaseView

/**
 * Created by Hnin Hsu Hlaing
 * on 8/26/2020
 */
interface UpNextView  : BaseView {
    fun play_Random_Podcast(podcast : List<RandomPodcastVO>)
    fun show_all_podcast(latestpodCastList: List<ItemVO>)
    fun navigate_to_Podcast_Detail(id: String)
    fun downloadPodcast()
    fun checkPermission(itemVO: ItemVO)
}