package com.padcx.podcastapp_hhh.delegates

import com.padcx.podcastapp_hhh.data.vo.ItemVO

/**
 * Created by Hnin Hsu Hlaing
 * on 8/26/2020
 */
interface UpNextDelegate {
    fun onTapPodCast_Item(itemVO: ItemVO)
    fun onTapDownload(itemVO: ItemVO)
}