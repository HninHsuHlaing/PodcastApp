package com.padcx.podcastapp_hhh.data.model

import android.annotation.SuppressLint
import android.content.Context
import androidx.lifecycle.LiveData
import com.padcx.podcastapp_hhh.data.dummy.getAllGenreList
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.data.vo.GenreVO
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse
import com.padcx.podcastapp_hhh.persistent.db.PodcastDb
import com.padcx.podcastapp_hhh.startDownload
import com.padcx.podcastapp_hhh.util.PARAM_API_KEY
import io.reactivex.schedulers.Schedulers
import io.reactivex.android.schedulers.AndroidSchedulers


/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
object PodcastModelImpl :PodcastModel , BaseModel() {

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
    private fun save_random_podcast_to_db(){
        mPodcastApi.loadRandomPodcastEpisode(PARAM_API_KEY)
            .map{
                it
            }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe {
                mPodcastDb.RandomPodcastDaos().insertRandomPodcast(it)
            }
    }
    override fun getRandomPodcast(): LiveData<List<RandomPodcastVO>> {
        save_random_podcast_to_db()
        return mPodcastDb.RandomPodcastDaos().getRandomPodcast()
    }



    @SuppressLint("CheckResult")
    private fun save_PlayList_Podcast_item(){
        mPodcastApi.loadPodCastPlaylistInfoAndItem(PARAM_API_KEY,"SgTozE1ZAe3")
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
           .map { it }
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

    override fun downloadPodcast(context: Context, itemVO: ItemVO): Long {
        return startDownload(context,itemVO)
    }

    override fun saveDownloadItem(dataVO: DataVO) {
        mPodcastDb.DownloadDaos().insertData(dataVO)
    }

//    fun initDatabase(context: Context){
//        mPodcastDb = PodcastDb.getDbInstance(context)
//    }


}