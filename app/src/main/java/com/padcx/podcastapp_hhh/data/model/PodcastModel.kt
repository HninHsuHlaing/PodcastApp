package com.padcx.podcastapp_hhh.data.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.data.vo.GenreVO
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
interface PodcastModel  {

    ////Genre////
    fun getGenreList() : LiveData<List<GenreVO>>
   // fun getAllDummyGenreList() : List<GenreVO>

    /////Random Podcast////
    fun getRandomPodcast() : LiveData<List<RandomPodcastVO>>

    /////PlayList/////
    fun getPlayListInfoFromDb() : LiveData<List<ItemVO>>


    ////DetailPodcast////
     fun save_detailPodcast(pid : String)
    fun get_DetailPodcast(pid: String) : LiveData<GetDetailResponse>


    ///Download
    fun downloadPodcast(context: Context, itemVO: ItemVO) : Long
    fun saveDownloadItem(dataVO: DataVO)
}