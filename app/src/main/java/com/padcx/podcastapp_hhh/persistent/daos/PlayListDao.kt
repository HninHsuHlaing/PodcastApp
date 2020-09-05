package com.padcx.podcastapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.podcastapp_hhh.data.vo.ItemVO

@Dao
interface PlayListDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertPlayList(playlist: List<ItemVO>)

    @Query("SELECT * FROM playlist")
    fun getAllPlayList(): LiveData<List<ItemVO>>
}