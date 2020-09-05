package com.padcx.podcastapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.podcastapp_hhh.data.vo.DataVO

@Dao
interface DownloadDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertData(dataVO: DataVO)

    @Query("select * from podcast_data")
    fun getAllDownloadData():LiveData<List<DataVO>>
}