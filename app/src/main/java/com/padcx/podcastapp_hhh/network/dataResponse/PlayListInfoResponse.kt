package com.padcx.podcastapp_hhh.network.dataResponse

import com.google.gson.annotations.SerializedName
import com.padcx.podcastapp_hhh.data.vo.ItemVO

/**
 * Created by Hnin Hsu Hlaing
 * on 9/4/2020
 */
data class PlayListInfoResponse (
    @SerializedName("description")var description: String,
    @SerializedName("id")var id: String,
    @SerializedName("image")var image: String,
    @SerializedName("items")var item: List<ItemVO>,
    @SerializedName("last_timestamp_ms")var last_timestamp_ms: Long,
    @SerializedName("listennotes_url")var listennotes_url: String,
    @SerializedName("name")var name: String,
    @SerializedName("thumbnail")var thumbnail: String,
    @SerializedName("total")var total: Int,
    @SerializedName("type")var type: String,
    @SerializedName("visibility")var visibility: String
)