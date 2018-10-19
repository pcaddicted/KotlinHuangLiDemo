package com.wb.kotlin.hl.api


import com.wbb.kotlinapp.bean.CalentarDayBean
import com.wbb.kotlinapp.bean.CalentarDayData
import com.wbb.kotlinapp.bean.CalentarDayResult
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by 文博 on 2018/10/19
 */
interface RetrofitService{

    @GET("calendar/day")
    fun calenderDay(
            @Query("date") date: String,
            @Query("key") key: String
    ): Observable<CalentarDayBean<CalentarDayResult<CalentarDayData>>>

}