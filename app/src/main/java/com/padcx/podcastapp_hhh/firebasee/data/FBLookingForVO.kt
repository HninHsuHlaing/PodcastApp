package com.padcx.podcastapp_hhh.firebasee.data

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

/**
 * Created by Hnin Hsu Hlaing
 * on 9/26/2020
 */
@IgnoreExtraProperties
class FBLookingForVO (
   var  cohosts: Boolean? = true,
    var cross_promotion: Boolean? = true,
    var  guests: Boolean? = true,
    var sponsors: Boolean? = true
)