package com.padcx.podcastapp_hhh.data.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.data.vo.GenreVO
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse
import com.padcx.podcastapp_hhh.network.dataResponse.RandomPodcstResponse

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
interface PodcastModel  {

    ////Genre////
    fun getGenreList() : LiveData<List<GenreVO>>
   // fun getAllDummyGenreList() : List<GenreVO>

    /////Random Podcast////
    fun save_random_podcast_to_db()
    fun getRandomPodcast() : LiveData<RandomPodcstResponse>

    /////PlayList/////
    fun getPlayListInfoFromDb() : LiveData<List<ItemVO>>


    ////DetailPodcast////
     fun save_detailPodcast(pid : String)
    fun get_DetailPodcast(pid: String) : LiveData<GetDetailResponse>


    ///Download
    fun downloadPodcast(context: Context, itemVO: ItemVO) : Long
    //SaveDownlodItem
    fun saveDownloadItem(dataVO: DataVO)
    // getDownloadFromDb
    fun getAllDownload():LiveData<List<DataVO>>
}