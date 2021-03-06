package com.padcx.podcastapp_hhh.firebasee.data

import com.google.firebase.database.IgnoreExtraProperties
import com.google.gson.annotations.SerializedName

/**
 * Created by Hnin Hsu Hlaing
 * on 9/26/2020
 */
@IgnoreExtraProperties
class FBExtraVO (
   var facebook_handle: String? = "",
   var google_url: String? = "",
    var instagram_handle: String? = "",
   var linkedin_url: String? = "",
    var patreon_handle: String? = "",
    var spotify_url: String? = "",
    var twitter_handle: String? = "",
    var url1: String? = "",
    var url2: String? = "",
    var url3: String? = "",
    var wechat_handle: String? = "",
    var youtube_url: String? = ""
)