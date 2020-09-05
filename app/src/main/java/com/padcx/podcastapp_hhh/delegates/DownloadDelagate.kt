package com.padcx.podcastapp_hhh.delegates

import com.padcx.podcastapp_hhh.data.vo.DataVO

/**
 * Created by Hnin Hsu Hlaing
 * on 9/5/2020
 */
interface DownloadDelagate {
    fun OnTapDownloadItem(dataVO: DataVO)
}