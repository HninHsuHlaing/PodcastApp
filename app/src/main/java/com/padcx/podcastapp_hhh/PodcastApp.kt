package com.padcx.podcastapp_hhh

import android.app.Application
import com.padcx.podcastapp_hhh.data.model.PodcastModelImpl


/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
class PodcastApp : Application() {
    override fun onCreate() {
        super.onCreate()
    PodcastModelImpl.initDatabase(applicationContext)
    }

}