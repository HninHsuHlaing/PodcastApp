package com.padcx.podcastapp_hhh.persistent.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.padcx.podcastapp_hhh.data.vo.*
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse
import com.padcx.podcastapp_hhh.network.dataResponse.RandomPodcstResponse
import com.padcx.podcastapp_hhh.persistent.daos.*

/**
 * Created by Hnin Hsu Hlaing
 * on 9/2/2020
 */

@Database(entities = [GenreVO::class,RandomPodcastVO::class,PodcastVO::class,
ItemVO::class,DataVO::class, GetDetailResponse::class,RandomPodcstResponse::class
],version = 3,exportSchema = false)
abstract class PodcastDb : RoomDatabase() {

    companion object{
        val Tour_DB= "PodcastDb"
        var dbinstnce :PodcastDb?= null
        fun getDbInstance(context: Context):PodcastDb{
            when (dbinstnce){
                null->{
                    dbinstnce = Room.databaseBuilder(context,PodcastDb::class.java, Tour_DB)
                        .allowMainThreadQueries()
                        .fallbackToDestructiveMigration()
                        //.addMigrations(MIGRATION_1_4, MIGRATION_4_5, MIGRATION_5_6)
                        .build()
                }

            }
            val i = dbinstnce
            return i!!
        }
    }

    abstract fun GenreDaos() :GenreDaos
    abstract fun RandomPodcastDaos() : RandomPodcastDaos
    abstract fun PlaylistDaos() : PlayListDao
    abstract fun Detaildaos() : DetailDao
    abstract fun DownloadDaos() : DownloadDao
}