package com.padcx.podcastapp_hhh.fragments

import android.Manifest
import android.app.DownloadManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.media.AudioAttributes
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.content.PermissionChecker.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.exoplayer2.ExoPlayerFactory
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.SimpleExoPlayer
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory
import com.google.android.exoplayer2.source.ExtractorMediaSource
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory
import com.google.android.exoplayer2.util.Log
import com.google.android.exoplayer2.util.Util
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.activities.DetailActivity
import com.padcx.podcastapp_hhh.adapters.UpNextAdapter
import com.padcx.podcastapp_hhh.data.vo.ItemVO
import com.padcx.podcastapp_hhh.data.vo.RandomPodcastVO
import com.padcx.podcastapp_hhh.delegates.UpNextDelegate
import com.padcx.podcastapp_hhh.mvp.presenters.HomePresenter
import com.padcx.podcastapp_hhh.mvp.presenters.impl.HomePresenterImpl
import com.padcx.podcastapp_hhh.mvp.views.UpNextView
import kotlinx.android.synthetic.main.main_player.*
import kotlinx.android.synthetic.main.player_home.*
import kotlinx.android.synthetic.main.up_next_activity.*
import kotlinx.android.synthetic.main.up_next_item.*

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class HomeFragment : Fragment() ,UpNextView
{
    private val STORAGE_PERMISSION_CODE: Int = 1000
    var flag = false
    private lateinit var mPresenter: HomePresenter
    lateinit var mUpNextAdapter: UpNextAdapter

    lateinit var song :MediaPlayer
    private lateinit var simpleExoplayer: SimpleExoPlayer
    private var listener: OnFragmentInteractionListener? = null
    private var downloadId  :Long = 0
    private var mData: ItemVO? = null
    companion object{
        const val REQUEST_CODE = 100
        fun newInstance()= HomeFragment().apply {
            arguments = Bundle().apply {

            }
        }
    }

    private  val downloadReceiver :BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            val id = intent?.getLongExtra(DownloadManager.EXTRA_DOWNLOAD_ID,-1)
                if(downloadId == id){
                        mData?.data?.let {
                            mPresenter.saveDownload(it)
                        }
                }
        }

    }
    private fun init() {
        context?.registerReceiver(downloadReceiver,
            IntentFilter(DownloadManager.ACTION_DOWNLOAD_COMPLETE)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
       init()
        setUpRecycler()
        mPresenter.onUiReady(this)


//        btnplayMain.setOnClickListener {
//            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//                if(checkSelfPermission(requireContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE) == PERMISSION_DENIED){
//                    requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),STORAGE_PERMISSION_CODE)
//                }else{
//                    startDownloading()
//                }
//            }
//        }

        btnplayMain.setOnClickListener {

            if(flag == false){
               // playMedia("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
               playMp3Song()
               var duration = (song.duration)/1000
                var durationHour = duration/60
                var durationMin = duration%60
               tvtimeLeft.text = durationHour.toString() + "m" +durationMin.toString() +"sec"
                flag = true
            }else{
                song.pause()
                var durationLeft = (song.duration-song.currentPosition)/1000
                var durationletHour = durationLeft/60
                var durationleftmin = durationLeft%60
                tvtimeLeft.text = durationletHour.toString()+"m"+durationleftmin.toString()+"sec left"
                flag = false
            }
        }
        btnforward.setOnClickListener {

            song.seekTo(song.currentPosition+1500)
        }
        btnbackward.setOnClickListener {
            song.seekTo(song.currentPosition-1500)
        }


     //   exoVideoPlayer()
        exoplayer.visibility =View.GONE
       // exoPlayerMp3()////this is the real exoplayer


      //  exoVideoPlayer()
//        btnVdPlay.setOnClickListener {
//            videoPlayer()
//        }
    }

    private fun downloadfile() {
        imgCloudDownload.setOnClickListener {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                if(checkSelfPermission(requireContext(),Manifest.permission.WRITE_EXTERNAL_STORAGE) == PERMISSION_DENIED){
                    requestPermissions(arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),STORAGE_PERMISSION_CODE)
                }else{
                    startDownloading()
                }
            }else{
               startDownloading()
            }
        }
    }

    private fun startDownloading() {
        val url ="https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3"
        val request = DownloadManager.Request(Uri.parse(url))
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE or DownloadManager.Request.NETWORK_WIFI)
        request.setTitle("Download")
        request.setDescription("The file is downloading........")
        request.allowScanningByMediaScanner()
        request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED)
        request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS,"${System.currentTimeMillis()}")
        val manager :DownloadManager = context?.getSystemService(Context.DOWNLOAD_SERVICE) as DownloadManager
        manager.enqueue(request)
    }

    private fun setUpPresenter() {
        mPresenter = HomePresenterImpl()
        mPresenter.initPresenter(this)
    }


    private fun playMedia(uri : String) {
         song = MediaPlayer.create(requireContext(),Uri.parse(uri))
          song.start()
        var currentPosition = song.currentPosition / 1000
        progressbar.progress = currentPosition
        btnforward.setOnClickListener {
            song.seekTo(1500)
        }
        btnbackward.setOnClickListener {
            song.seekTo(-1500)
        }
    }
    private fun playMp3Song() {
        song = MediaPlayer.create(requireContext(),R.raw.good_luck)
        song.start()
        var currentPosition = song.currentPosition / 1000
        progressbar.progress = currentPosition

        progressbar.setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener {

            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {

            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }


        })
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

    override fun onPause() {
        super.onPause()
        context?.unregisterReceiver(downloadReceiver)
      //  song.pause()
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
//            setUpRecycler()


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
        mUpNextAdapter = UpNextAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        upNext_Recycler?.layoutManager = linearLayoutManager
        upNext_Recycler?.adapter = mUpNextAdapter
    }

    override fun play_Random_Podcast(podcast : List<RandomPodcastVO>) {
        btnplayMain.setOnClickListener {
            if(flag == false){
                playMedia(podcast.last().listennotes_url)
                flag = true
            }else{
                song.pause()
                flag = false
            }
        }
        tvTitlehomePlayer.text = podcast.last().title
        tvdescriptionHomePlayer.text = podcast.last().thumbnail


    }


    override fun show_all_podcast(latestpodCastList: List<ItemVO>) {
        mUpNextAdapter.setNewsData(latestpodCastList)
    }

    override fun navigate_to_Podcast_Detail(id: String) {
        startActivity(DetailActivity.newIntent(requireContext(),id))

      //  downloadfile()

    }

    override fun downloadPodcast() {
        startDownloading()
    }

    override fun checkPermission(itemVO: ItemVO) {

        mData = itemVO
        when {
            context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            } == PackageManager.PERMISSION_GRANTED -> {
                context?.let {
                    downloadId = mPresenter.download(it, mData!!)
                }
            }
            else -> {
                requestPermissions(
                    arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                    REQUEST_CODE
                )
            }
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        when(requestCode){
            STORAGE_PERMISSION_CODE ->{
                if(grantResults.isNotEmpty() && grantResults[0] ==PackageManager.PERMISSION_GRANTED){
                    startDownloading()
                }else{
                    Log.d("Tag","Permission Denied")
                }
            }
        }
    }


}

