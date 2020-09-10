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
import com.padcx.podcastapp_hhh.adapters.SearchAdapter
import com.padcx.podcastapp_hhh.data.vo.GenreVO
import com.padcx.podcastapp_hhh.mvp.presenters.SearchPresenter
import com.padcx.podcastapp_hhh.mvp.presenters.impl.SearchPresenterImpl
import com.padcx.podcastapp_hhh.mvp.views.SearchView
import kotlinx.android.synthetic.main.categories_activity.*

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class SearchFragment : Fragment() ,SearchView {
   private lateinit var  mSearchAdapter  : SearchAdapter
    private lateinit var mPresenter: SearchPresenter
    companion object{
        fun newInstance()= SearchFragment().apply {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpPresenter()
        setUpRecycler()
        mPresenter.onUiReady(this)
    }

    private fun setUpPresenter() {
        mPresenter = ViewModelProviders.of(this).get(SearchPresenterImpl::class.java)
        mPresenter.initPresenter(this)
    }

    private fun setUpRecycler() {
        mSearchAdapter = SearchAdapter()
        val linearLayoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        categories_recycler.layoutManager = linearLayoutManager
        categories_recycler.adapter = mSearchAdapter
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.categories_activity,container,false)
    }

    interface OnFragmentInteractionListener {

        fun onFragmentInteraction(uri: Uri)
    }

    override fun show_all_caterogries(list: List<GenreVO>) {
        mSearchAdapter.setData(list)
    }


}