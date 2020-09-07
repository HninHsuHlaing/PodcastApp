package com.padcx.podcastapp_hhh.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.activities.DetailActivity
import com.padcx.podcastapp_hhh.adapters.DownloadAdapter
import com.padcx.podcastapp_hhh.data.vo.DataVO
import com.padcx.podcastapp_hhh.delegates.UpNextDelegate
import com.padcx.podcastapp_hhh.mvp.presenters.DownloadPresenter
import com.padcx.podcastapp_hhh.mvp.presenters.impl.DownloadPresenterImpl
import com.padcx.podcastapp_hhh.mvp.views.DownloadView
import kotlinx.android.synthetic.main.download_activity.*

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class DownloadFragment :Fragment(),DownloadView
    {
        private lateinit var mPresenter: DownloadPresenter
    lateinit var mDownload_Adapter: DownloadAdapter
    companion object{
        fun newInstance()=DownloadFragment().apply {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        mPresenter.onUiReady(this)
        setUpRecycler()
    }

        private fun setUpPresenter() {
        //    mPresenter = DownloadPresenterImpl()
            mPresenter = ViewModelProviders.of(this).get(DownloadPresenterImpl::class.java)
            mPresenter.initPresenter(this)
        }

        private fun setUpRecycler() {
        mDownload_Adapter = DownloadAdapter(mPresenter)
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        download_Recycler.layoutManager = linearLayoutManager
        download_Recycler.adapter = mDownload_Adapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.download_activity,container,false)
    }
    interface OnFragmentInteractionListener {
        fun onFragmentInteraction(uri: Uri)
    }



    override fun show_all_downloaded_podcast(dataVO: List<DataVO>) {
        mDownload_Adapter.setNewsData(dataVO)
    }

    override fun navigate_to_Detail_Podcast(id:String) {
        startActivity(DetailActivity.newIntent(requireContext(),id))
    }


}