package com.padcx.podcastapp_hhh.mvp.presenters.impl

import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import com.padcx.podcastapp_hhh.data.model.PodcastModel
import com.padcx.podcastapp_hhh.data.model.PodcastModelImpl
import com.padcx.podcastapp_hhh.mvp.presenters.SearchPresenter
import com.padcx.podcastapp_hhh.mvp.views.SearchView
import com.padcx.shared.presenter.AbstractBasePresenter

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
class SearchPresenterImpl : SearchPresenter, AbstractBasePresenter<SearchView>() {

    var mPodcastModel:PodcastModel =PodcastModelImpl
    override fun onUiReady(lifeCycleOwner: LifecycleOwner) {
        ////for Real Data///
//        mPodcastModel.getGenreList().observe(lifeCycleOwner, Observer{
//            mView?.show_all_caterogries(it)
//        })


        mPodcastModel.getGenerList(
        onSuccess = {
            mView?.show_all_caterogries(it)
        },
            onFaiure = {
            Log.d("Caterogries Error ", it)
            }
            )


            ///for Dummy Data////
//        var dummyGenreData =mPodcastModel.getAllDummyGenreList()
//        mView?.show_all_caterogries(dummyGenreData)
        }
    }


