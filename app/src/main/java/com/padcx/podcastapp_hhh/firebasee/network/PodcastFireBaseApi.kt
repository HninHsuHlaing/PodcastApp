package com.padcx.podcastapp_hhh.firebasee.network

import android.database.Observable
import androidx.lifecycle.LiveData
import com.padcx.podcastapp_hhh.firebasee.data.GenreVOFIreBase
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.firebasee.data.FBDataVO
import com.padcx.podcastapp_hhh.firebasee.data.FBItemVO
import com.padcx.podcastapp_hhh.firebasee.data.FBRandomPodcastVO

/**
 * Created by Hnin Hsu Hlaing
 * on 9/26/2020
 */
interface PodcastFireBaseApi {

    fun getGeners(onSuccess: (genersList: List<GenreVOFIreBase>) -> Unit, onFialure: (String) -> Unit)

    fun getPlaylist(onSuccess: (playlist: List<FBItemVO>) -> Unit, onFialure: (String) -> Unit)
     fun getRandomPodcast(onSuccess: (randomPodcast: List<FBRandomPodcastVO>) -> Unit, onFialure: (String) -> Unit)
    fun getDetail( podcastID: String,
                   onSuccess: (playlist: List<FBItemVO>) -> Unit,
                   onFialure: (String) -> Unit)
}