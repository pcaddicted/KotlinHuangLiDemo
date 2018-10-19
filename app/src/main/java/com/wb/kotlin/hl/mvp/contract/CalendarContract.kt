package com.wb.kotlin.hl.mvp.contract

import com.wb.kotlin.hl.base.BasePresenter
import com.wb.kotlin.hl.base.BaseView
import com.wb.kotlin.hl.base.IPresenter
import com.wbb.kotlinapp.bean.CalentarDayBean
import com.wbb.kotlinapp.bean.CalentarDayData
import com.wbb.kotlinapp.bean.CalentarDayResult

/**
 * Created by 文博 on 2018/10/19
 */
interface  CalendarContract {

    interface View : BaseView {
        fun showDayCalentarData(calentarDayBean: CalentarDayBean<CalentarDayResult<CalentarDayData>>)
        fun showError(errorMsg: String)
    }

    abstract class Presenter : BasePresenter<View>() {
         abstract fun getDayCalentarData(date: String)
    }

}