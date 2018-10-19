package com.wb.kotlin.hl.base

/**
 * Created by 文博 on 2018/10/19
 */
interface BasePresenter {
    /**
     * 开启订阅
     */
    fun subscribe()

    /**
     * 结束订阅
     */
    fun unsubscribe()

}