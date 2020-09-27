package com.padcx.podcastapp_hhh.firebasee.data

import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
import com.padcx.podcastapp_hhh.data.vo.PodcastVO

/**
 * Created by Hnin Hsu Hlaing
 * on 9/26/2020
 */

 class FBDataVO(
    var audio: String? = "",
   var audio_length_sec: Int? = 0,
   var description: String? = "",
    var explicit_content: Boolean? = true,
    var data_id: String? = "",
    var image: String? = "",
    var link: String? = "",
    var listennotes_edit_url: String? = "",
    var listennotes_url: String? = "",
    var maybe_audio_invarid: Boolean? = true,
    var podcast: FBPodcastVO,
    var pub_date_ms: Long? = 0,
    var thumbnail: String? = "",
    var title: String? = ""
)