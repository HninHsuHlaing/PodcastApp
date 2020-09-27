package com.padcx.podcastapp_hhh.firebasee.data

import androidx.room.Embedded
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO

/**
 * Created by Hnin Hsu Hlaing
 * on 9/27/2020
 */
@IgnoreExtraProperties
class FBRandomPodcastVO (
    var maybe_audio_invarid: Boolean? = true,
    var id: String? = "",
    var audio: String? = "",
    var audio_length_sec: Int? = 0,
    var description: String? = "",
    var explicit_content: Boolean? = true,
    var image: String? = "",
    var link: String? = "",
    var listennotes_edit_url: String? = "",
    var listennotes_url: String? = "",


//    @Embedded(prefix = "_RandomPodcast")

    var podcast: FBPodcastVO? = null,
    var pub_date_ms: Long? = 0,
    var thumbnail: String? = "",
    var title: String? = ""
)