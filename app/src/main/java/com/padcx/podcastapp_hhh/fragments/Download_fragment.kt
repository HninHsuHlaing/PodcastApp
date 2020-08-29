package com.padcx.podcastapp_hhh.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.activities.Detail_Activity
import com.padcx.podcastapp_hhh.adapters.Download_Adapter
import com.padcx.podcastapp_hhh.delegates.Up_next_Delegate
import kotlinx.android.synthetic.main.download_activity.*

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class Download_fragment :Fragment(),Up_next_Delegate{
    lateinit var mDownload_Adapter: Download_Adapter
    companion object{
        fun newInstance()=Download_fragment().apply {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
    }

    private fun setUpRecycler() {
        mDownload_Adapter = Download_Adapter(this)
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
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    override fun onTapPodCast_Item() {
        startActivity(Detail_Activity.newIntent(requireContext()))
    }


}