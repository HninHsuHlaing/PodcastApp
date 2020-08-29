package com.padcx.podcastapp_hhh.fragments

import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.padcx.podcastapp_hhh.R
import com.padcx.podcastapp_hhh.adapters.Search_Adapter
import kotlinx.android.synthetic.main.categories_activity.*

/**
 * Created by Hnin Hsu Hlaing
 * on 8/25/2020
 */
class Search_fragment : Fragment() {
    lateinit var  mSearchAdapter  : Search_Adapter
    companion object{
        fun newInstance()= Search_fragment().apply {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRecycler()
    }

    private fun setUpRecycler() {
        mSearchAdapter = Search_Adapter()
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
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

}