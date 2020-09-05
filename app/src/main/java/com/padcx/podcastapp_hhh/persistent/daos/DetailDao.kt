package com.padcx.podcastapp_hhh.persistent.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse

@Dao
interface DetailDao {
    @Query("SELECT * FROM detail")
    fun getAllDetail() : LiveData<List<GetDetailResponse>>

    @Query("SELECT * FROM detail WHERE id = :detailId")
    fun getDetailById(detailId :String) : LiveData<GetDetailResponse>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetail(detail: GetDetailResponse)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertDetailList(detailList:GetDetailResponse)
}