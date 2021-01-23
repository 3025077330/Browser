package com.example.browserxfive

import android.app.Application
import android.util.Log
import android.util.Log.e
import com.tencent.smtt.sdk.QbSdk
import com.tencent.smtt.sdk.QbSdk.PreInitCallback


class App : Application() {


    companion object {
        var instance: App? = null
        val TAG = "App";
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
        initTbs();

    }

    fun initTbs() {
        //搜集本地tbs内核信息并上报服务器，服务器返回结果决定使用哪个内核。
        val cb: PreInitCallback = object : PreInitCallback {
            override fun onViewInitFinished(arg0: Boolean) {
                //x5內核初始化完成的回调，为true表示x5内核加载成功，否则表示x5内核加载失败，会自动切换到系统内核。
                e(TAG, " =========onViewInitFinished is $arg0")
            }

            override fun onCoreInitFinished() {
            }
        }
        //x5内核初始化接口
        QbSdk.initX5Environment(applicationContext, cb)
    }
}