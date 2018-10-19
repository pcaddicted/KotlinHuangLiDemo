package com.wb.kotlin.hl

import com.wb.kotlin.hl.base.BaseMvpActivity
import com.wb.kotlin.hl.mvp.contract.CalendarContract
import com.wb.kotlin.hl.mvp.presenter.CalendarPresenter
import com.wbb.kotlinapp.bean.CalentarDayBean
import com.wbb.kotlinapp.bean.CalentarDayData
import com.wbb.kotlinapp.bean.CalentarDayResult

class MainActivity : BaseMvpActivity<CalendarContract.View, CalendarContract.Presenter>(), CalendarContract.View {


    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun createPresenter(): CalendarContract.Presenter {
        return CalendarPresenter(this)
    }

    override fun initData() {

    }

    override fun initView() {
//        selectButton.run {
//            onClick {
//                titleTextView.visibility = View.GONE
//                selectButton.visibility = View.GONE
//                contentTextView.visibility = View.GONE
//                datePicker.visibility = View.VISIBLE
//            }
//        }
//
//        datePicker.run {
//            init(2018, 10, 19, DatePicker.OnDateChangedListener { view, year, month, day ->
//                var date: String = "${year}-${month + 1}-${day}"
//                presenter.getDayCalentarData(date)
//            })
//        }
    }

    override fun initListener() {
    }

    override fun showDayCalentarData(calentarDayBean: CalentarDayBean<CalentarDayResult<CalentarDayData>>) {
    }

    override fun showError(errorMsg: String) {
    }

    override fun showProgressBar() {
    }

    override fun hideProgressBar() {
    }
}
//    : AppCompatActivity(),CalendarContract.View {
//
//    lateinit var presenter: CalendarContract.Presenter
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        presenter = CalendarPresenter(this)
//
//        selectButton.run {
//            onClick {
//                titleTextView.visibility= View.GONE
//                selectButton.visibility=View.GONE
//                contentTextView.visibility = View.GONE
//                datePicker.visibility = View.VISIBLE
//            }
//        }
//
//        datePicker.run {
//            init(2018,10,19, DatePicker.OnDateChangedListener{
//                view, year, month, day ->
//                var date: String = "${year}-${month+1}-${day}"
//                presenter.getDayCalentarData(date)
//            })
//        }
//    }
//
//    override fun showDayCalentarData(calentarDayBean: CalentarDayBean<CalentarDayResult<CalentarDayData>>) {
//        datePicker.visibility=View.GONE
//        titleTextView.visibility = View.VISIBLE
//        selectButton.visibility = View.VISIBLE
//        contentTextView.visibility = View.VISIBLE
//        titleTextView.text=calentarDayBean.result.data.date
//        contentTextView.text = calentarDayBean.result.data.toString()
//    }
//
//    override fun showError(errorMsg: String) {
//        toast(errorMsg)
//    }
//
//    override fun showProgressBar() {
//
//    }
//
//    override fun hideProgressBar() {
//
//    }
//
//    override fun onResume() {
//        super.onResume()
//        presenter.attachView(this)
//    }
//
//    override fun onDestroy() {
//        super.onDestroy()
//        presenter.detachView()
//    }
//}
