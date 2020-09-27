package com.padcx.podcastapp_hhh.views.viewPod

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import com.bumptech.glide.Glide
//import com.example.postcast_reactive_mvp.R
//import com.example.shared.extensions.checkTime
//import com.example.shared.extensions.load
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.ui.PlayerControlView
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.padcx.podcastapp_hhh.R
import kotlinx.android.synthetic.main.custom_layout.view.ivEpisodeTitle
import kotlinx.android.synthetic.main.custom_layout.view.ivPodcast


class ExoPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : PlayerControlView(context, attrs, defStyleAttr) {

    private var playWhenReady = false
    private var currentWindow = 0
    private lateinit var simpleExoplayer: SimpleExoPlayer
    private var playbackPosition: Long = 0

    private var mDelegate : MideaPlayerViewPod.Delegate? = null


    override fun onFinishInflate() {
        super.onFinishInflate()
        initializePlayer()
    }

    private fun initializePlayer() {
        simpleExoplayer = SimpleExoPlayer.Builder(context).build()
        player = simpleExoplayer
        val userAgent = Util.getUserAgent(context, context.getString(R.string.app_name))
        //val uri = Uri.parse(context.getString(R.string.media_url_mp3))
//        val uri = Uri.parse("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
//        val mediaSource = buildMediaSource(uri)
//        val mediaSource1 = ExtractorMediaSource
//            .Factory(DefaultDataSourceFactory(context, userAgent))
//            .setExtractorsFactory(DefaultExtractorsFactory())
//            .createMediaSource(Uri.parse("https://www.listennotes.com/e/p/11b34041e804491b9704d11f283c74de/"))
//        simpleExoplayer.setPlayWhenReady(playWhenReady)
//        simpleExoplayer.seekTo(currentWindow, playbackPosition)
//        simpleExoplayer.prepare(mediaSource, true, true)

    }

    private fun buildMediaSource(uri: Uri): MediaSource {
        val dataSourceFactory: DataSource.Factory =
            DefaultDataSourceFactory(context, "PodcastExoPlayer")
        return ProgressiveMediaSource.Factory(dataSourceFactory)
            .createMediaSource(uri)
    }



    fun setData(title: String?, playUrl:String?, url: String?){
        ivEpisodeTitle.text = title
       // ivPodcast.load(url)
        Glide
            .with(this)
            .load(url)
            .into(ivPodcast)
        val uri = Uri.parse(playUrl)
        val mediaSource = buildMediaSource(uri)
        simpleExoplayer?.playWhenReady = playWhenReady
        simpleExoplayer?.seekTo(currentWindow, playbackPosition)
       // simpleExoplayer?.addListener(playbackStateListener)
        simpleExoplayer?.prepare(mediaSource, false, false)

    }




}