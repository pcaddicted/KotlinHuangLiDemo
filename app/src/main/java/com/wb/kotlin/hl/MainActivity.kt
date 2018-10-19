package com.wb.kotlin.hl

import android.view.View
import android.widget.DatePicker
import com.wb.kotlin.hl.base.BaseMvpActivity
import com.wb.kotlin.hl.mvp.contract.CalendarContract
import com.wb.kotlin.hl.mvp.presenter.CalendarPresenter
import com.wbb.kotlinapp.bean.CalentarDayBean
import com.wbb.kotlinapp.bean.CalentarDayData
import com.wbb.kotlinapp.bean.CalentarDayResult
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity : BaseMvpActivity<CalendarContract.View, CalendarPresenter>(), CalendarContract.View {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun createPresenter(): CalendarPresenter {
        return CalendarPresenter()
    }

    override fun initData() {

    }

    override fun initView() {
        selectButton.run {
            onClick {
                titleTextView.visibility = View.GONE
                selectButton.visibility = View.GONE
                contentTextView.visibility = View.GONE
                datePicker.visibility = View.VISIBLE
            }
        }

        datePicker.run {
            init(2018, 10, 19, DatePicker.OnDateChangedListener { view, year, month, day ->
                var date: String = "${year}-${month + 1}-${day}"
                mPresenter.getDayCalentarData(date)
            })
        }
    }

    override fun initListener() {

    }

    override fun showDayCalentarData(calentarDayBean: CalentarDayBean<CalentarDayResult<CalentarDayData>>) {
        datePicker.visibility = View.GONE
        titleTextView.visibility = View.VISIBLE
        selectButton.visibility = View.VISIBLE
        contentTextView.visibility = View.VISIBLE
        titleTextView.text = calentarDayBean.result.data.date
        contentTextView.text = calentarDayBean.result.data.toString()
    }

    override fun showError(errorMsg: String) {
        toast(errorMsg)
    }

    override fun showProgressBar() {
    }

    override fun hideProgressBar() {
    }

}

