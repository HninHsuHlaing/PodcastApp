package com.padcx.podcastapp_hhh

import android.app.DownloadManager
import android.content.Context
import android.net.Uri
import android.os.Environment
import com.padcx.podcastapp_hhh.data.vo.ItemVO

/**
 * Created by Hnin Hsu Hlaing
 * on 9/5/2020
 */
fun startDownload(context: Context, itemVO: ItemVO) : Long {
//    val downloadId: Long
//    val uri = Uri.parse(itemVO.data.link.split("?").first())
//    val request = DownloadManager.Request(uri).apply {
//        setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
//        setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, uri.lastPathSegment)
//        setTitle(itemVO.data.title)
//        setAllowedOverMetered(true)
//        setAllowedOverRoaming(true)
//    }
//    val dManager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
//    downloadId = dManager.enqueue(request)
//    return downloadId

    val downloadId: Long
    // val uri = Uri.parse(itemVO.data.audio)
    val request = DownloadManager.Request(Uri.parse(itemVO.data
        .audio)).apply {
        setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${itemVO.data.title.trim().substring(0,8)}.mp3")
        setTitle(itemVO.data.title)
        setAllowedOverMetered(true)
        setAllowedOverRoaming(true)
    }
    val dManager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
    downloadId = dManager.enqueue(request)
    return downloadId

}