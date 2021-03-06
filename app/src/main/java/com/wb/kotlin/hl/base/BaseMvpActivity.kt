package com.wb.kotlin.hl.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by 文博 on 2018/10/19
 */
abstract class BaseMvpActivity<V : BaseView ,out T : BasePresenter<V>>:AppCompatActivity(),BaseView{

    val mPresenter by lazy { createPresenter() }

    @Suppress("UNCHECKED_CAST")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mPresenter.attachView(this as V)
        setContentView(getLayoutId())
        initData()
        initView()
        initListener()
    }

    abstract fun getLayoutId(): Int

    abstract fun createPresenter():T

    abstract fun initData()

    abstract fun initView()

    abstract fun initListener()

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detachView()
    }
}