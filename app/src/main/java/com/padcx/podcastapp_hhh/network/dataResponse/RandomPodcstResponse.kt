package com.padcx.podcastapp_hhh.network.dataResponse

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import com.padcx.podcastapp_hhh.data.vo.GenreVO
import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO
import java.util.ArrayList

/**
 * Created by Hnin Hsu Hlaing
 * on 9/2/2020
 */

@Entity(tableName = "random_podcast")
data class RandomPodcstResponse (
    @PrimaryKey
    @SerializedName("id")var id: String,
    @SerializedName("audio")var audio: String,
    @SerializedName("audio_length_sec")var audio_length_sec: Int,
    @SerializedName("description")var description: String,
    @SerializedName("explicit_content")var explicit_content: Boolean,
    @SerializedName("image")var image: String,
    @SerializedName("link")var link: String,
    @SerializedName("listennotes_edit_url")var listennotes_edit_url: String,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("maybe_audio_invarid")var maybe_audio_invarid: Boolean,

    @Embedded(prefix = "_RandomPodcast")
    @SerializedName("podcast")var randomPodcast: RandomPodcastVO,

    @SerializedName("pub_date_ms")var pub_date_ms: Long,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("title")var title: String
)