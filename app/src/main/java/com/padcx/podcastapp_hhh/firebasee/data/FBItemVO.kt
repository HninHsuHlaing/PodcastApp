package com.padcx.podcastapp_hhh.firebasee.data

import com.google.firebase.database.IgnoreExtraProperties

/**
 * Created by Hnin Hsu Hlaing
 * on 9/26/2020
 */
@IgnoreExtraProperties
data class FBItemVO(
 var id: Int? = 0,
 var added_at_ms: Long? = 0,

    //  @Embedded(prefix = "_dataVO")
 var data: FBDataVO? = null,
 var notes: String? = "",
 var type: String? = "",

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
 var pub_date_ms: Long? = 0,
 var thumbnail: String? = "",
 var title: String? = ""
)

