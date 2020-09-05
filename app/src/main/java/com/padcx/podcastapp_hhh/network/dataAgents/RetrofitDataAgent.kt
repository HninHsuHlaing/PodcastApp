package com.padcx.podcastapp_hhh.network.dataAgents

import com.padcx.podcastapp_hhh.PodcastApi
import com.padcx.podcastapp_hhh.util.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
object RetrofitDataAgent {

    private var mPodcastApi : PodcastApi? = null

    init {

        val mOkHttpClient = OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(15, TimeUnit.SECONDS)
            .build()

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        mPodcastApi = retrofit.create(PodcastApi::class.java)

    }
}