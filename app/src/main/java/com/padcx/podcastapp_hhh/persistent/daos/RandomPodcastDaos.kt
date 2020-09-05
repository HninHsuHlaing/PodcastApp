package com.padcx.podcastapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.podcastapp_hhh.data.vo.GenreVO
import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO
import com.padcx.podcastapp_hhh.network.dataResponse.RandomPodcstResponse

/**
 * Created by Hnin Hsu Hlaing
 * on 9/2/2020
 */
@Dao
interface RandomPodcastDaos {
    @Query("SELECT * FROM RandomPodcstEpisode_Table")
    fun getRandomPodcast(): LiveData<List<RandomPodcastVO>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRandomPodcast(podCastVORandom: RandomPodcstResponse)
}