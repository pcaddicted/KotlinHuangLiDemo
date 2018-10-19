package com.wb.kotlin.hl.base

interface IPresenter<V:BaseView> {

    fun attachView(mView: V)

    fun detachView()

}