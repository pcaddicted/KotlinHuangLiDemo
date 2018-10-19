package com.wb.kotlin.hl.base

import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.Reference
import java.lang.ref.WeakReference

/**
 * Created by 文博 on 2018/10/19
 */
abstract class BasePresenter<V> {
    /**
     * 绑定
     */
    lateinit var viewRef: Reference<V>
    lateinit var compositeDisposable: CompositeDisposable

    fun attachView(view:V){
        viewRef = WeakReference<V>(view)
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