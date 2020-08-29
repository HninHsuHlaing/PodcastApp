package com.padcx.podcastapp_hhh.activities

import android.accessibilityservice.GestureDescription
import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.SimpleExoPlayer
import com.padcx.podcastapp_hhh.R


/**
 * Created by Hnin Hsu Hlaing
 * on 8/26/2020
 */
class Detail_Activity : AppCompatActivity() {
    private lateinit var simpleExoplayer: SimpleExoPlayer
    companion object{
        fun newIntent(context: Context) : Intent{
            val intent =  Intent(context, Detail_Activity::class.java)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_detail)
        val song :MediaPlayer = MediaPlayer.create(this,R.raw.good_luck)
      //  song.start()
        exomediaPlayer()

    }

    private fun exomediaPlayer() {
     //   val player: SimpleExoPlayer = Builder(this).build()

    }
}