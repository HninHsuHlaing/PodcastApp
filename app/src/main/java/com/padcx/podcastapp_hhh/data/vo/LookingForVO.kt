package com.padcx.podcastapp_hhh.data.vo

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

data class LookingForVO(
    @SerializedName("cohosts")val cohosts: Boolean,
    @SerializedName("cross_promotion")val cross_promotion: Boolean,
    @SerializedName("guests")val guests: Boolean,
    @SerializedName("sponsors")val sponsors: Boolean
)