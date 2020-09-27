package com.padcx.podcastapp_hhh.activities

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.SimpleExoPlayer
import com.padcx.podcastapp_hhh.util.MyMediaPlayerHelper
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.firebasee.data.FBItemVO
import com.padcx.podcastapp_hhh.mvp.presenters.DetailPresenter
import com.padcx.podcastapp_hhh.mvp.presenters.impl.DetailPresenterImpl
import com.padcx.podcastapp_hhh.mvp.views.DetailView
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse
import com.padcx.podcastapp_hhh.views.viewPod.MediaPlayer.MiniMusicPlayerViewPod
import com.padcx.podcastapp_hhh.views.viewPod.SmallExoPlayerViewPod
import kotlinx.android.synthetic.main.show_detail.*


/**
 * Created by Hnin Hsu Hlaing
 * on 8/26/2020
 */
class DetailActivity : AppCompatActivity() ,DetailView{
    lateinit var mDetailPresenter: DetailPresenter
    private lateinit var simpleExoplayer: SimpleExoPlayer
    private lateinit var mMiniMusicPlayerViewPod: MiniMusicPlayerViewPod
    private lateinit var mExoPlayerViewPod : SmallExoPlayerViewPod
    private var initPlayer=true
    companion object{
        const val podcastId = "Podcast Id Extra"
        fun newIntent(context: Context,pid:String) : Intent{
            val intent =  Intent(context, DetailActivity::class.java)
            intent.putExtra(podcastId,pid)
            return intent
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.show_detail)
        val song :MediaPlayer = MediaPlayer.create(this,R.raw.good_luck)
      //  song.start()
        setUpPresenter()
        setUpViewPod()
        minimusicplayerviewpod.visibility = View.GONE
        val Podcast_id = intent.getStringExtra(podcastId)
        Podcast_id?.let { mDetailPresenter.onUiReady(this, it) }

//        btnbackdownload.setOnClickListener {
//        startActivity(HomeActivity.newIntent(this))
//        }


    }

    private fun setUpViewPod() {
        mExoPlayerViewPod = player_control_view as SmallExoPlayerViewPod

        mMiniMusicPlayerViewPod = minimusicplayerviewpod as MiniMusicPlayerViewPod
        mMiniMusicPlayerViewPod.setDelegate(mDetailPresenter)
    }

    private fun setUpPresenter() {
        mDetailPresenter = ViewModelProviders.of(this).get(DetailPresenterImpl::class.java)
        mDetailPresenter.initPresenter(this)
    }

    private fun exomediaPlayer() {
     //   val player: SimpleExoPlayer = Builder(this).build()

    }

    override fun showDetailPodcast(detailResponse: List<FBItemVO>) {
        Glide
            .with(this)
            .load(detailResponse[0].image)
            .into(imgdetail)
         tvDetailName.text = detailResponse[0].title
       // tvDetailType.text = detailResponse.podcastVO.type
        tvDetilDescription.text = Html.fromHtml(detailResponse[0].description)
        //mMiniMusicPlayerViewPod.setUpData(detailResponse.audio)
        mMiniMusicPlayerViewPod.setUpData("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
        mExoPlayerViewPod.setSamllDataBinder(detailResponse[0].audio_length_sec,detailResponse[0].audio)
      //  Log.d("Audio",detailResponse.audio)
    }

    override fun onTouchPlayPauseIcon(audioUri: String) {
        if(initPlayer) {
            MyMediaPlayerHelper.initMediaPlayer(
                this, audioUri,
                mMiniMusicPlayerViewPod.getSeekBar(),
                mMiniMusicPlayerViewPod.getPlayPauseImage(),
                mMiniMusicPlayerViewPod.getCurrentTimeLabel(),
                mMiniMusicPlayerViewPod.getTotalTimeLabel()
            )
            initPlayer=false
        }
        MyMediaPlayerHelper.playPauseMediaPlayBack(this)
    }

    override fun onTouchForwardThirtySecIcon() {
        MyMediaPlayerHelper.forwardMediaPlayBack(this)
    }

    override fun onTouchBackwardFifteenSecIcon() {
        MyMediaPlayerHelper.backwardMediaPlayBack(this)
    }
}