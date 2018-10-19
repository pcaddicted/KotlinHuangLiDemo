package com.wb.kotlin.hl.mvp.presenter

import android.util.Log
import com.wb.kotlin.hl.api.RetrofitUtil
import com.wb.kotlin.hl.mvp.contract.CalendarContract
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers


/**
 * Created by 文博 on 2018/10/19
 */
class CalendarPresenter(val view: CalendarContract.View):CalendarContract.Presenter {

    var compositeDisposable:CompositeDisposable

    companion object {
        const val TAG = "CalentarPresenter"
    }

    init {
        compositeDisposable = CompositeDisposable()
    }

    override fun getDayCalentarData(date: String) {
        val disposable = RetrofitUtil
                .retrofitService
                .calenderDay(date, "933dc930886c8c0717607f9f8bae0b48")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ result ->
                    view.showDayCalentarData(result)
                    Log.e(TAG, result.toString())
                }, { error ->
                    view.showError(error.message.toString())
                    Log.e(TAG, error.message.toString())
                })
        compositeDisposable.add(disposable)
    }

    override fun subscribe() {

    }

    override fun unsubscribe() {
        compositeDisposable.clear()
    }
}