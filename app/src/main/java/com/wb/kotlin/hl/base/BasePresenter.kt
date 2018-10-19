package com.wb.kotlin.hl.base

import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.Reference
import java.lang.ref.WeakReference

/**
 * Created by 文博 on 2018/10/19
 */
abstract class BasePresenter<T> {
    /**
     * 绑定
     */
    lateinit var viewRef: Reference<T>
    lateinit var compositeDisposable: CompositeDisposable

    fun attachView(view:T){
        viewRef = WeakReference<T>(view)
        compositeDisposable = CompositeDisposable()
    }

    /**
     * 解除绑定
     */
    fun detachView(){
        viewRef.clear()
        compositeDisposable.clear()
    }
}