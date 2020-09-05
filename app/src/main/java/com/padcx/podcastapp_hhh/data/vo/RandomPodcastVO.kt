package com.padcx.podcastapp_hhh.data.vo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

/**
 * Created by Hnin Hsu Hlaing
 * on 9/2/2020
 */

@Entity(tableName = "RandomPodcstEpisode_Table")
data class RandomPodcastVO (
    @PrimaryKey
    @SerializedName("id")var random_id: String,
    @SerializedName("image")var image: String,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("publisher")var publisher: String,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("title")var title: String
)