package com.padcx.podcastapp_hhh.data.model

import android.annotation.SuppressLint
import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import com.padcx.podcastapp_hhh.data.vo.*
import com.padcx.podcastapp_hhh.firebasee.data.FBDataVO
import com.padcx.podcastapp_hhh.firebasee.data.FBItemVO
import com.padcx.podcastapp_hhh.firebasee.data.FBRandomPodcastVO
import com.padcx.podcastapp_hhh.firebasee.data.GenreVOFIreBase
import com.padcx.podcastapp_hhh.firebasee.network.PodcastFireBaseApi
import com.padcx.podcastapp_hhh.firebasee.network.PodcastRealTimeDataBaseeImpl
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse
import com.padcx.podcastapp_hhh.network.dataResponse.RandomPodcstResponse
import com.padcx.podcastapp_hhh.startDownload
import com.padcx.podcastapp_hhh.util.PARAM_API_KEY
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers


/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
object PodcastModelImpl :PodcastModel , BaseModel() {
    override var firebasePodcastApi: PodcastFireBaseApi =
        PodcastRealTimeDataBaseeImpl
    override fun getGenerList(onSuccess: (List<GenreVOFIreBase>) -> Unit, onFaiure: (String) -> Unit) {
        firebasePodcastApi.getGeners(onSuccess,onFaiure)
    }
    override fun getPlayliat(onSuccess: (List<FBItemVO>) -> Unit, onFaiure: (String) -> Unit) {
        firebasePodcastApi.getPlaylist(onSuccess,onFaiure)
    }
    override fun getRandomPodcast(
        onSuccess: (List<FBRandomPodcastVO>) -> Unit,
        onFaiure: (String) -> Unit
    ) {
        firebasePodcastApi.getRandomPodcast(onSuccess,onFaiure)
    }
    override fun getDetail( podcastID: String,
                            onSuccess: (playlist: List<FBItemVO>) -> Unit,
                            onFialure: (String) -> Unit) {
      // firebasePodcastApi.getDetail(podcastID,onSuccess,onFialure)
    }






    @SuppressLint("CheckResult")
    private fun save_genre_list_to_db(){

        mPodcastApi.loadGenresList(PARAM_API_KEY,"0")
            .map {
            it.genres
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                it.let {
                    mPodcastDb.GenreDaos().insertAllGenreList(it)
                }

            }
    }




    override fun getGenreList(): LiveData<List<GenreVO>> {
        save_genre_list_to_db()
        return mPodcastDb.GenreDaos().getAllGenreList()
       // return getAllGenreList()

    }




    @SuppressLint("CheckResult")
    override fun save_random_podcast_to_db() {
        mPodcastApi.loadRandomPodcastEpisode(PARAM_API_KEY)
            .map{
                Log.d("Tag",it.toString())
                it

            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mPodcastDb.RandomPodcastDaos().insertRandomPodcast(it)
            }

    }
    override fun getRandomPodcast(): LiveData<RandomPodcstResponse> {
        save_random_podcast_to_db()
        //Log.d("Random Data",mPodcastDb.RandomPodcastDaos().getRandomPodcast().toString())
        return mPodcastDb.RandomPodcastDaos().getRandomPodcast()
    }




    @SuppressLint("CheckResult")
    private fun save_PlayList_Podcast_item(){
        mPodcastApi.loadPodCastPlaylistInfoAndItem(PARAM_API_KEY,"m1pe7z60bsw")
            .map {
                it.item.toList()
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
            it.let {
            mPodcastDb.PlaylistDaos().insertPlayList(it)
            }
            }
    }
    override fun getPlayListInfoFromDb(): LiveData<List<ItemVO>> {
        save_PlayList_Podcast_item()
        return mPodcastDb.PlaylistDaos().getAllPlayList()
    }

    @SuppressLint("CheckResult")
    override fun save_detailPodcast(pid : String){
       mPodcastApi.loadDetailForEpisode(PARAM_API_KEY,pid)
           .map {
               it
           }
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
           .subscribe {
               it.let {
                   mPodcastDb.Detaildaos().insertDetailList(it)
               }
           }

    }

    override fun get_DetailPodcast(pid: String): LiveData<GetDetailResponse> {
        return mPodcastDb.Detaildaos().getDetailById(pid)
    }



    override fun downloadPodcast(context: Context, itemVO: FBItemVO): Long {
        return startDownload(context,itemVO)
    }

    override fun saveDownloadItem(dataVO: FBDataVO) {
      //  mPodcastDb.DownloadDaos().insertData(dataVO)
    }

    override fun getAllDownload(): LiveData<List<DataVO>> {
        return mPodcastDb.DownloadDaos().getAllDownloadData()
    }

//    fun initDatabase(context: Context){
//        mPodcastDb = PodcastDb.getDbInstance(context)
//    }


}