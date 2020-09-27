package com.padcx.podcastapp_hhh.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

@IgnoreExtraProperties
@Entity(tableName = "GenreTable")
 class GenreVO(
    @PrimaryKey
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("image_url") val image: String,
    @SerializedName("parent_id") val parent_id: Int

//   var id: Int? = 0,
//   var name: String? =  "",
//   var image: String? ="",
//   var parent_id: Int? = 0
)