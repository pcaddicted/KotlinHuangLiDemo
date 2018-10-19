package com.wb.kotlin.hl

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import com.wb.kotlin.hl.mvp.contract.CalendarContract
import com.wb.kotlin.hl.mvp.presenter.CalendarPresenter
import com.wbb.kotlinapp.bean.CalentarDayBean
import com.wbb.kotlinapp.bean.CalentarDayData
import com.wbb.kotlinapp.bean.CalentarDayResult
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.toast

class MainActivity : AppCompatActivity(),CalendarContract.View {

    lateinit var presenter: CalendarContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        presenter = CalendarPresenter(this)

        selectButton.run {
            onClick {
                titleTextView.visibility= View.GONE
                selectButton.visibility=View.GONE
                contentTextView.visibility = View.GONE
                datePicker.visibility = View.VISIBLE
            }
        }

        datePicker.run {
            init(2018,10,19, DatePicker.OnDateChangedListener{
                view, year, month, day ->
                var date: String = "${year}-${month+1}-${day}"
                presenter.getDayCalentarData(date)
            })
        }
    }

    override fun showDayCalentarData(calentarDayBean: CalentarDayBean<CalentarDayResult<CalentarDayData>>) {
        datePicker.visibility=View.GONE
        titleTextView.visibility = View.VISIBLE
        selectButton.visibility = View.VISIBLE
        contentTextView.visibility = View.VISIBLE
        titleTextView.text=calentarDayBean.result.data.date
        contentTextView.text = calentarDayBean.result.data.toString()
    }

    override fun showError(errorMsg: String) {
        toast(errorMsg)
    }

    override fun showProgressBar() {
    }

    override fun hideProgressBar() {

    }

    override fun onResume() {
        super.onResume()
        presenter.subscribe()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.unsubscribe()
    }
}
