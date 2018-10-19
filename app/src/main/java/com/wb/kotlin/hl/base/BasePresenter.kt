package com.wb.kotlin.hl.base

import io.reactivex.disposables.CompositeDisposable
import java.lang.ref.Reference
import java.lang.ref.WeakReference


/**
 * Created by 文博 on 2018/10/19
 */
abstract class BasePresenter<V:BaseView> : IPresenter<V>{
    lateinit var viewRef: Reference<V>
    lateinit var compositeDisposable: CompositeDisposable
    /**
     * 绑定到视图执行的操作
     */
    override fun attachView(mView:V){
        viewRef = WeakReference(mView)
        compositeDisposable = CompositeDisposable()
    }

    /**
     * 拿到当前视图
     */
    fun obtainView():V?{
        return viewRef?.run{
            viewRef.get()
        }
    }

    /**
     * 解除绑定
     */
     override fun detachView(){
        viewRef.clear()
        compositeDisposable.clear()
    }
}