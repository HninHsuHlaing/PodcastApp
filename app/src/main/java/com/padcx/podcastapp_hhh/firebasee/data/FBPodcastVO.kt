package com.padcx.podcastapp_hhh.firebasee.data

import androidx.room.PrimaryKey
import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName
import com.padcx.podcastapp_hhh.data.vo.ExtraVO
import com.padcx.podcastapp_hhh.data.vo.LookingForVO

/**
 * Created by Hnin Hsu Hlaing
 * on 9/26/2020
 */
@IgnoreExtraProperties
class FBPodcastVO(
     var country: String? = "",
    var description: String? = "",
    var earliest_pub_date_ms: Long? =0,
    var email: String? = "",
    var explicit_content: Boolean? = true,

    var extra: FBExtraVO? = null,

    var genre_ids: List<Int>? = arrayListOf(),


    var pid: String? = "",
   var image: String? = "",
     var is_claimed: Boolean? = true,
     var itunes_id: Int? =0,
  var language: String? = "",
     var latest_pub_date_ms: Long? =0,
    var listennotes_url: String? = "",

     var looking_for: FBLookingForVO? = null,
     var publisher: String? = "",
    var rss: String? = "",
     var thumbnail: String? = "",
     var title: String? = "",
     var total_episodes: Int? =0,
   var type: String? = "",
    var website: String? = ""
)