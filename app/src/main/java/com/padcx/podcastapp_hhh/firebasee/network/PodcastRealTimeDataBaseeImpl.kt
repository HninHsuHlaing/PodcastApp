package com.padcx.podcastapp_hhh.firebasee.network

import android.util.Log
import androidx.lifecycle.LiveData
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.firebasee.data.FBDataVO
import com.padcx.podcastapp_hhh.firebasee.data.FBItemVO
import com.padcx.podcastapp_hhh.firebasee.data.FBRandomPodcastVO
import com.padcx.podcastapp_hhh.firebasee.data.GenreVOFIreBase
import kotlinx.android.synthetic.main.empty_view_pod.view.*

/**
 * Created by Hnin Hsu Hlaing
 * on 9/26/2020
 */
object PodcastRealTimeDataBaseeImpl :
    PodcastFireBaseApi {
    private val database: DatabaseReference = Firebase.database.reference

    override fun getGeners(
        onSuccess: (genersList: List<GenreVOFIreBase>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("genres").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
            val genrelist = arrayListOf<GenreVOFIreBase>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(GenreVOFIreBase::class.java)?.let {
                        genrelist.add(it)
                    }
                }
                onSuccess(genrelist)
            }
        })

    }

    override fun getPlaylist(
        onSuccess: (playlist: List<FBItemVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("items").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
               // Log.d("Playlist Error",error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val playlist = arrayListOf<FBItemVO>()
                snapshot.children.forEach { dataSnapShot ->
                    dataSnapShot.getValue(FBItemVO::class.java)?.let {
                        playlist.add(it)
                    }
                }
                onSuccess(playlist)
            }

        })
    }

    override fun getRandomPodcast(
        onSuccess: (randomPodcast: List<FBRandomPodcastVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("randomPodcast").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
               val randomPodcast  = arrayListOf<FBRandomPodcastVO>()
                snapshot.children.forEach {dataSnapShot ->
                    dataSnapShot.getValue(FBRandomPodcastVO::class.java)?.let {
                        randomPodcast.add(it)
                    }

                }
                onSuccess(randomPodcast)
            }

        })
    }

    override fun getDetail(
        podcastID: String,
        onSuccess: (playlist: List<FBItemVO>) -> Unit,
        onFialure: (String) -> Unit
    ) {
        database.child("details").addValueEventListener(object : ValueEventListener{
            override fun onCancelled(error: DatabaseError) {
                onFialure(error.message)
            }

            override fun onDataChange(snapshot: DataSnapshot) {
                val playlistdetail = arrayListOf<FBItemVO>()

            }

        })
    }


}

