package com.padcx.podcastapp_hhh.fragments

import android.content.Context
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.ExoPlayerFactory.newSimpleInstance
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.source.hls.HlsMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.SimpleExoPlayerView
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory
import com.google.android.exoplayer2.util.Util
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.activities.Detail_Activity
import com.padcx.podcastapp_hhh.adapters.Up_Next_Adapter
import com.padcx.podcastapp_hhh.delegates.Up_next_Delegate
import com.padcx.podcastapp_hhh.mvp.views.Up_next_view
import kotlinx.android.synthetic.main.main_player.*
import kotlinx.android.synthetic.main.player_home.*
import kotlinx.android.synthetic.main.up_next_activity.*
import java.net.URL

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class Home_Fragment : Fragment() ,Up_next_view ,Up_next_Delegate
{
    lateinit var song :MediaPlayer
    lateinit var mUpNextAdapter: Up_Next_Adapter
    private lateinit var simpleExoplayer: SimpleExoPlayer
    private var listener: OnFragmentInteractionListener? = null
    companion object{
        fun newInstance()= Home_Fragment().apply {
            arguments = Bundle().apply {

            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
        var flag = false
        btnplayMain.setOnClickListener {
            if(flag == false){
                playMedia()
                flag = true
            }else{
                song.pause()
                flag = false
            }
        }


     //   exoVideoPlayer()
        exoplayer.visibility =View.GONE
       // exoPlayerMp3()////this is the real exoplayer


      //  exoVideoPlayer()
//        btnVdPlay.setOnClickListener {
//            videoPlayer()
//        }
    }

    private fun playMedia() {
         song = MediaPlayer.create(requireContext(),R.raw.good_luck)
          song.start()
    }

    private fun exoPlayerMp3() {
        var mediaSource: ProgressiveMediaSource? = null
            simpleExoplayer = SimpleExoPlayer.Builder(requireContext()).build()
        simpleExoplayer!!.repeatMode = Player.REPEAT_MODE_ALL
            exoplayer.player = simpleExoplayer
        val userAgent =
            Util.getUserAgent(exoplayer.context,"exoplayer")
        mediaSource = ProgressiveMediaSource
                .Factory(
            DefaultDataSourceFactory(requireContext(), userAgent),
            DefaultExtractorsFactory()
        )
            .createMediaSource(Uri.parse("https://c4.biketo.com/article_video/20190917/4jsDf5pEGC.mp4"))
        simpleExoplayer!!.prepare(mediaSource!!, true, false)
        simpleExoplayer!!.playWhenReady = true
    }

//    private fun exoPlayerMp3(uri :Uri): MediaSource {
//        val userAgent = Util.getUserAgent(requireContext(), "Exo")
//        return ExtractorMediaSource.Factory(DefaultDataSourceFactory(requireContext(), userAgent))
//            .setExtractorsFactory(DefaultExtractorsFactory()).createMediaSource(uri)
//    }

    override fun onStart() {
        super.onStart()
    }

    private fun exoVideoPlayer() {

        val uripath = "https://c4.biketo.com/article_video/20190917/4jsDf5pEGC.mp4"
        val userAgent = Util.getUserAgent(requireContext(),"playVideo")
        val bandwidthMeter = DefaultBandwidthMeter()
        val trackSelector = DefaultTrackSelector(AdaptiveTrackSelection.Factory(bandwidthMeter))
       // exoplayer.ExoPlayerFactory.newSimpleInstance(this,trackSelector)
        val exoPlayer : SimpleExoPlayer = ExoPlayerFactory.newSimpleInstance(requireContext(),trackSelector)
        val uri = Uri.parse("https://www.youtube.com/watch?v=FRv7lBYFY2g&list=RDFRv7lBYFY2g&start_radio=1")
        val defaultHttpDataFactory = DefaultDataSourceFactory(requireContext(),userAgent)
        val extrafactory = DefaultExtractorsFactory()
        val mediaSource = ExtractorMediaSource(uri,defaultHttpDataFactory,extrafactory,null,null)



        exoPlayer.prepare(mediaSource)
        exoPlayer.playWhenReady = true
        exoplayer.player = exoPlayer

     //   simpleExoplayer =SimpleExoPlayer
//        val trackSelector = DefaultTrackSelector()
//        val exoPlayer = SimpleExoPlayer.newSimpleInstance(baseContext,trackSelector)
//        exoPlayer?.player = exoPlayer

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       //return super.onCreateView(inflater, container, savedInstanceState)
       return inflater.inflate(R.layout.activity_main,container,false)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
            setUpRecycler()


    }

    private fun videoPlayer() {

       // vdView.start()
        val myUri: String ="https://www.youtube.com/watch?v=FRv7lBYFY2g&list=RDFRv7lBYFY2g&start_radio=1"
        val mediaPlayer: MediaPlayer? = MediaPlayer().apply {
            setAudioAttributes(
                AudioAttributes.Builder()
                    .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                    .setUsage(AudioAttributes.USAGE_MEDIA)
                    .build()
            )
            setDataSource(myUri)
            prepare() // might take long! (for buffering, etc)
            start()
        }
        mediaPlayer?.start()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else {
            throw RuntimeException(context.toString() + " must implement OnFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
    interface OnFragmentInteractionListener {

        fun onFragmentInteraction(uri: Uri)
    }

    private fun setUpRecycler() {
        mUpNextAdapter = Up_Next_Adapter(this)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        upNext_Recycler?.layoutManager = linearLayoutManager
        upNext_Recycler?.adapter = mUpNextAdapter
    }

    override fun navigate_to_PodCast_Detail() {
        startActivity(Detail_Activity.newIntent(requireContext()))
    }

    override fun onTapPodCast_Item() {
        startActivity(Detail_Activity.newIntent(requireContext()))
    }


}

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//    }
//
//    override fun onDetach() {
//        super.onDetach()
//    }