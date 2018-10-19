package com.wb.kotlin.hl.api

import android.util.Log
import com.wb.kotlin.hl.constant.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by 文博 on 2018/10/19
 */
class RetrofitUtil {
    companion object {
        const val TAG = "RetrofitUtil"

        /**
         * 创建Retrofit
         */
        fun create(url:String):Retrofit{
            //显示日志级别
            val level:HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BODY
            //新建log拦截器
            val loggingInterceptor = HttpLoggingInterceptor(HttpLoggingInterceptor.Logger {
                message -> Log.e(TAG,"OkHttp:$message")
            })

            loggingInterceptor.level = level

            val okHttpClient = OkHttpClient.Builder()
            okHttpClient.connectTimeout(60,TimeUnit.SECONDS)
            okHttpClient.readTimeout(10,TimeUnit.SECONDS)
            okHttpClient.addInterceptor(loggingInterceptor)

            return Retrofit.Builder()
                    .baseUrl(url)
                    .client(okHttpClient.build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build()
        }

        /**
         * 获取ServiceApi
         */
        fun <T> getService(url: String,service:Class<T>):T{
            return create(url).create(service)
        }

        val retrofitService:RetrofitService = RetrofitUtil.getService(Constants.REQUEST_BASE_URL,RetrofitService::class.java)
    }
}