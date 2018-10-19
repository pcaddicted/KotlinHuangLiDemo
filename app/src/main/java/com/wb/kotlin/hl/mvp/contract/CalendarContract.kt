package com.wb.kotlin.hl.mvp.contract

import com.wb.kotlin.hl.base.BasePresenter
import com.wb.kotlin.hl.base.BaseView
import com.wbb.kotlinapp.bean.CalentarDayBean
import com.wbb.kotlinapp.bean.CalentarDayData
import com.wbb.kotlinapp.bean.CalentarDayResult

/**
 * Created by 文博 on 2018/10/19
 */
abstract class CalendarContract {

    interface View : BaseView {
        fun showDayCalentarData(calentarDayBean: CalentarDayBean<CalentarDayResult<CalentarDayData>>)
        fun showError(errorMsg: String)
    }

    abstract class Presenter : BasePresenter<BaseView>() {
        abstract  fun getDayCalentarData(date: String)
    }

}