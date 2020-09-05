package com.padcx.podcastapp_hhh

import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO
import com.padcx.podcastapp_hhh.network.dataResponse.GenreResponse
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse
import com.padcx.podcastapp_hhh.network.dataResponse.PlayListInfoResponse
import com.padcx.podcastapp_hhh.network.dataResponse.RandomPodcstResponse
import com.padcx.podcastapp_hhh.util.GET_DETAIL_FOR_EPISODE
import com.padcx.podcastapp_hhh.util.GET_GENRES
import com.padcx.podcastapp_hhh.util.GET_PLAYLIST_INFO_AND_ITEM
import com.padcx.podcastapp_hhh.util.GET_RANDOMPODCAST
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
interface PodcastApi {
    @GET(GET_GENRES)
    fun loadGenresList(@Header("X-ListenAPI-Key") api_key: String,
                       @Query("top_level_only") value: String) : Observable<GenreResponse>

    @GET(GET_RANDOMPODCAST)
    fun loadRandomPodcastEpisode(@Header("X-ListenAPI-Key") api_key: String): Observable<RandomPodcstResponse>

    @GET(GET_PLAYLIST_INFO_AND_ITEM)
    fun loadPodCastPlaylistInfoAndItem(
        @Header("X-ListenAPI-Key") api_key: String,
        @Path("id") id:String
    ): Observable<PlayListInfoResponse>

    @GET(GET_DETAIL_FOR_EPISODE)
    fun loadDetailForEpisode(
        @Header("X-ListenAPI-Key") api_key: String,
        @Path("id") id: String
    ): Observable<GetDetailResponse>
}