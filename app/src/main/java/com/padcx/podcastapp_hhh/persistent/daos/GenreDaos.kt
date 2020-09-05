package com.padcx.podcastapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.podcastapp_hhh.data.vo.GenreVO

/**
 * Created by Hnin Hsu Hlaing
 * on 9/2/2020
 */
@Dao
interface GenreDaos {
    @Query("SELECT * FROM GenreTable")
    fun getAllGenreList(): LiveData<List<GenreVO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllGenreList(country: List<GenreVO>)

    @Query("SELECT * FROM GenreTable WHERE id = :generId")
    fun getGenerById(generId :Int) : LiveData<GenreVO>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertGener(genersVO: GenreVO)

}