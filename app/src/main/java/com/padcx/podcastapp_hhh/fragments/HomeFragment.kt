package com.padcx.podcastapp_hhh.fragments

import android.Manifest
import android.app.Activity
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
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.content.PermissionChecker.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.exoplayer2.util.Log
import com.padcx.podcastapp_hhh.util.MyMediaPlayerHelper
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.activities.DetailActivity
import com.padcx.podcastapp_hhh.adapters.UpNextAdapter
import com.padcx.podcastapp_hhh.firebasee.data.FBItemVO
import com.padcx.podcastapp_hhh.firebasee.data.FBRandomPodcastVO
import com.padcx.podcastapp_hhh.mvp.presenters.HomePresenter
import com.padcx.podcastapp_hhh.mvp.presenters.impl.HomePresenterImpl
import com.padcx.podcastapp_hhh.mvp.views.UpNextView
import com.padcx.podcastapp_hhh.views.viewPod.ExoPlayerViewPod
import com.padcx.podcastapp_hhh.views.viewPod.MediaPlayer.MusicPlayerPlayerViewPod
import kotlinx.android.synthetic.main.custom_layout.*
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
    private var initPlayer = true

    lateinit var song :MediaPlayer
    private lateinit var mExoPlayerViewPod : ExoPlayerViewPod
    private var listener: OnFragmentInteractionListener? = null
    private var downloadId  :Long = 0
    private var mData: FBItemVO? = null
    private lateinit var mMusicPlayerViewPod: MusicPlayerPlayerViewPod
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
        setUpViewPod()
        setUpRecycler()
        mPresenter.onUiReady(this)
     //   player_control_view.visibility = View.GONE
        musicplayerviewpod.visibility = View.GONE
        mediaCardView.visibility = View.GONE

//
    }

    private fun setUpViewPod() {
        mExoPlayerViewPod = player_control_view as ExoPlayerViewPod

        /////Media View////
        mMusicPlayerViewPod = musicplayerviewpod as MusicPlayerPlayerViewPod
        mMusicPlayerViewPod.setDelegate(mPresenter)
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
        mPresenter = ViewModelProviders.of(this).get(HomePresenterImpl::class.java)
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

    override fun onStart() {
        super.onStart()

    }

    override fun onPause() {
        super.onPause()
//        context?.unregisterReceiver(downloadReceiver)
      //  song.pause()
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

    override fun bind_Random_Podcast(podcast : List<FBRandomPodcastVO>) {
        tvDescription.text = Html.fromHtml( podcast[0].description)
        mExoPlayerViewPod.setData(
            podcast[0].title,
            podcast[0].audio,
            podcast[0].image
        )
       // Log.d("Song",podcast[0].audio)
        tvpodcasttitle.text=podcast[0].title
      //  mMusicPlayerViewPod.setData("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
       // mMusicPlayerViewPod.setData(podcast.audio)
        mMusicPlayerViewPod.setUpData(podcast[0].title,podcast[0].description,podcast[0].image,
            "https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
//        btnplayMain.setOnClickListener {
//            if(flag == false){
//                playMedia(podcast.audio)
//                flag = true
//            }else{
//                song.pause()
//                flag = false
//            }
//        }
//        tvTitlehomePlayer.text = podcast.title
//     //   tvdescriptionHomePlayer.text =
//        tvDescriptionPodcast.text=  podcast.description


    }


    override fun show_all_podcast(latestpodCastList: List<FBItemVO>) {
       // mUpNextAdapter.setNewsData(latestpodCastList)
        mUpNextAdapter.setData(latestpodCastList)
    }

    override fun navigate_to_Podcast_Detail(id: String) {
        startActivity(DetailActivity.newIntent(requireContext(),id))

      //  downloadfile()

    }

//    override fun downloadPodcast() {
//        startDownloading()
//    }

    override fun checkPermission(itemVO: FBItemVO) {

        mData = FBItemVO()
        when {
            context?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
                )
            } == PackageManager.PERMISSION_GRANTED -> {
                context?.let {
                    downloadId = mPresenter.download(it, mData!!)
                   // Log.d("Downloaded", mData!!.data.link.toString())
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

    override fun onTouchPlayPauseImage(audioUrl: String) {
        if (initPlayer) {
            MyMediaPlayerHelper.initMediaPlayer(
                activity as Activity, audioUrl,
                mMusicPlayerViewPod.getSeekBar(),
                mMusicPlayerViewPod.getPlayPauseImage(),
                mMusicPlayerViewPod.getRemainingTime(),
                mMusicPlayerViewPod.getRemainingTime()
            )
            initPlayer = false
        }
        MyMediaPlayerHelper.playPauseMediaPlayBack(activity as Activity)
    }

    override fun onTouchForwardThirtySecIcon() {
        MyMediaPlayerHelper.forwardMediaPlayBack(activity as Activity)
    }

    override fun onTouchBackwardFifteenSecIcon() {
        MyMediaPlayerHelper.backwardMediaPlayBack(activity as Activity)
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

