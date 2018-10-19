package com.wb.kotlin.hl.base

import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by 文博 on 2018/10/19
 */
abstract class BaseMvpActivity<V,T:BasePresenter<V>>:AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}