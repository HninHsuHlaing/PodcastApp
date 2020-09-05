package com.padcx.podcastapp_hhh.network.dataResponse

import com.google.gson.annotations.SerializedName
import com.padcx.podcastapp_hhh.data.vo.GenreVO
import java.util.ArrayList

/**
 * Created by Hnin Hsu Hlaing
 * on 9/2/2020
 */
data class GenreResponse (

    @SerializedName("genres")
    val genres :ArrayList<GenreVO> = arrayListOf()
)