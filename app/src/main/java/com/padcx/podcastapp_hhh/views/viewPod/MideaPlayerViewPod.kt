package com.padcx.podcastapp_hhh.views.viewPod

import android.content.Context
import android.util.AttributeSet
import android.widget.RelativeLayout
import kotlinx.android.synthetic.main.custom_layout.view.*
import kotlinx.android.synthetic.main.media_play_back.view.*

class MideaPlayerViewPod @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : RelativeLayout(context, attrs, defStyleAttr) {


    private var mDelegate : Delegate? = null
    override fun onFinishInflate() {
        super.onFinishInflate()
        setUpListener()
    }

    fun setDelegate(delegate: Delegate){
        this.mDelegate = delegate
    }

    fun setData(title:String,duration:Int,url:String){
     //   ivEpisodeTitle.text = title
     //   ivPodcast.load(url)
     //   tvDuration.text = duration.checkTime()
    }


    private fun setUpListener(){
        tvBackward.setOnClickListener {
            mDelegate?.onTouchFifteenSec()
        }
        tvForward.setOnClickListener {
            mDelegate?.onTouchThirtySec()
        }

    }

    interface Delegate{
        fun onTouchFifteenSec()
        fun onTouchThirtySec()
    }
}