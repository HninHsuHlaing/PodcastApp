package com.padcx.podcastapp_hhh.data.model

import android.content.Context
import androidx.lifecycle.LiveData
import com.padcx.podcastapp_hhh.data.vo.*
import com.padcx.podcastapp_hhh.firebasee.data.FBDataVO
import com.padcx.podcastapp_hhh.firebasee.data.FBItemVO
import com.padcx.podcastapp_hhh.firebasee.data.FBRandomPodcastVO
import com.padcx.podcastapp_hhh.firebasee.data.GenreVOFIreBase
import com.padcx.podcastapp_hhh.firebasee.network.PodcastFireBaseApi
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse
import com.padcx.podcastapp_hhh.network.dataResponse.RandomPodcstResponse

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
interface PodcastModel  {

    var firebasePodcastApi : PodcastFireBaseApi
    ////Genre////
    fun getGenerList(onSuccess: (List<GenreVOFIreBase>) -> Unit, onFaiure: (String) -> Unit)
    fun getGenreList() : LiveData<List<GenreVO>>
   // fun getAllDummyGenreList() : List<GenreVO>

    /////Random Podcast////
    fun save_random_podcast_to_db()
    fun getRandomPodcast() : LiveData<RandomPodcstResponse>
    fun getRandomPodcast(onSuccess: (List<FBRandomPodcastVO>) -> Unit, onFaiure: (String) -> Unit)

    /////PlayList/////
    fun getPlayliat(onSuccess: (List<FBItemVO>) -> Unit, onFaiure: (String) -> Unit)
    fun getPlayListInfoFromDb() : LiveData<List<ItemVO>>


    ////DetailPodcast////
     fun save_detailPodcast(pid : String)
    fun get_DetailPodcast(pid: String) : LiveData<GetDetailResponse>
    fun getDetail( podcastID: String,
                   onSuccess: (playlist: List<FBItemVO>) -> Unit,
                   onFialure: (String) -> Unit)


    ///Download
    fun downloadPodcast(context: Context, itemVO: FBItemVO) : Long
    //SaveDownlodItem
    fun saveDownloadItem(dataVO: FBDataVO)
    // getDownloadFromDb
    fun getAllDownload():LiveData<List<DataVO>>
}