package com.padcx.podcastapp_hhh.activities

import android.content.Context
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.google.android.exoplayer2.SimpleExoPlayer
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.mvp.presenters.DetailPresenter
import com.padcx.podcastapp_hhh.mvp.presenters.impl.DetailPresenterImpl
import com.padcx.podcastapp_hhh.mvp.views.DetailView
import com.padcx.podcastapp_hhh.network.dataResponse.GetDetailResponse
import kotlinx.android.synthetic.main.show_detail.*


/**
 * Created by Hnin Hsu Hlaing
 * on 8/26/2020
 */
class DetailActivity : AppCompatActivity() ,DetailView{
    lateinit var mDetailPresenter: DetailPresenter
    private lateinit var simpleExoplayer: SimpleExoPlayer
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
        val Podcast_id = intent.getIntExtra(podcastId, 0)
        mDetailPresenter.onUiReady(this,Podcast_id.toString())
        exomediaPlayer()

    }

    private fun setUpPresenter() {
        mDetailPresenter = DetailPresenterImpl()
        mDetailPresenter.initPresenter(this)
    }

    private fun exomediaPlayer() {
     //   val player: SimpleExoPlayer = Builder(this).build()

    }

    override fun showDetailPodcast(detailResponse: GetDetailResponse) {
        Glide
            .with(this)
            .load(detailResponse.image)
            .into(imgdetail)
        tvDetailName.text = detailResponse.title
        tvDetilDescription.text = detailResponse.description
    }
}