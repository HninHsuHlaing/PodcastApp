package com.padcx.shared.presenter

import com.padcx.shared.view.BaseView

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
interface BasePresenter <T :BaseView> {
    fun initPresenter(view: T)
}