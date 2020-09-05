package com.padcx.shared.presenter

import androidx.lifecycle.ViewModel
import com.padcx.shared.view.BaseView

/**
 * Created by Hnin Hsu Hlaing
 * on 9/1/2020
 */
abstract class AbstractBasePresenter <T :BaseView> : BasePresenter<T>, ViewModel() {
    var mView : T? = null

    override fun initPresenter(view: T) {
        mView = view
    }
}