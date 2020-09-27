package com.padcx.podcastapp_hhh.firebasee.data

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

/**
 * Created by Hnin Hsu Hlaing
 * on 9/26/2020
 */
@IgnoreExtraProperties
class GenreVOFIreBase (
    var id: Int? = 0,
    var name: String? =  "",
    var image_url: String? ="",
    val parent_id: Int? = 0

)