package com.example.browserxfive

import android.content.res.Configuration
import android.graphics.PixelFormat
import android.os.Bundle
import android.view.View
import android.webkit.JavascriptInterface
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.tencent.smtt.sdk.WebChromeClient
import kotlinx.android.synthetic.main.activity_main.*


/**
 * 我们可以封装一个BaseWebViewActivity用来加载WebView    SingTop启动模式
 */
class MainActivity : AppCompatActivity() {


    val url =
        "https://www.ixigua.com/6740628248339677700?fromvsogou=1&utm_source=sogou_duanshipin&utm_medium=sogou_referral&utm_campaign=cooperation"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.loadUrl(url)
        window.setFormat(PixelFormat.TRANSLUCENT)

        webView!!.view.overScrollMode = View.OVER_SCROLL_ALWAYS
        //webView!!.addJavascriptInterface(MyJs(), "android")
        webView!!.setWebChromeClient(WebChromeClient())

    }

    class MyJs {
        @JavascriptInterface
        fun back(): String {
            //enableX5FullscreenFunc()

            return "android!"
        }
    }


    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)

        try {
            super.onConfigurationChanged(newConfig)
            if (resources.configuration.orientation == Configuration.ORIENTATION_LANDSCAPE) {
            } else if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    // 向webview发出信息
    fun enableX5FullscreenFunc() {
        if (webView.x5WebViewExtension != null) {
            Toast.makeText(this, "开启X5全屏播放模式", Toast.LENGTH_LONG).show()
            val data = Bundle()
            data.putBoolean("standardFullScreen", false) // true表示标准全屏，false表示X5全屏；不设置默认false，
            data.putBoolean("supportLiteWnd", false) // false：关闭小窗；true：开启小窗；不设置默认true，
            data.putInt("DefaultVideoScreen", 2) // 1：以页面内开始播放，2：以全屏开始播放；不设置默认：1
            webView.x5WebViewExtension.invokeMiscMethod(
                "setVideoParams",
                data
            )
        }
    }

    private fun disableX5FullscreenFunc() {
        if (webView.x5WebViewExtension != null) {
            Toast.makeText(this, "恢复webkit初始状态", Toast.LENGTH_LONG).show()
            val data = Bundle()
            data.putBoolean(
                "standardFullScreen",
                true
            ) // true表示标准全屏，会调起onShowCustomView()，false表示X5全屏；不设置默认false，
            data.putBoolean("supportLiteWnd", false) // false：关闭小窗；true：开启小窗；不设置默认true，
            data.putInt("DefaultVideoScreen", 2) // 1：以页面内开始播放，2：以全屏开始播放；不设置默认：1
            webView.x5WebViewExtension.invokeMiscMethod(
                "setVideoParams",
                data
            )
        }
    }

    private fun enableLiteWndFunc() {
        if (webView.x5WebViewExtension != null) {
            Toast.makeText(this, "开启小窗模式", Toast.LENGTH_LONG).show()
            val data = Bundle()
            data.putBoolean(
                "standardFullScreen",
                false
            ) // true表示标准全屏，会调起onShowCustomView()，false表示X5全屏；不设置默认false，
            data.putBoolean("supportLiteWnd", true) // false：关闭小窗；true：开启小窗；不设置默认true，
            data.putInt("DefaultVideoScreen", 2) // 1：以页面内开始播放，2：以全屏开始播放；不设置默认：1
            webView.x5WebViewExtension.invokeMiscMethod(
                "setVideoParams",
                data
            )
        }
    }

    private fun enablePageVideoFunc() {
        if (webView.x5WebViewExtension != null) {
            Toast.makeText(this, "页面内全屏播放模式", Toast.LENGTH_LONG).show()
            val data = Bundle()
            data.putBoolean(
                "standardFullScreen",
                false
            ) // true表示标准全屏，会调起onShowCustomView()，false表示X5全屏；不设置默认false，
            data.putBoolean("supportLiteWnd", false) // false：关闭小窗；true：开启小窗；不设置默认true，
            data.putInt("DefaultVideoScreen", 1) // 1：以页面内开始播放，2：以全屏开始播放；不设置默认：1
            webView.x5WebViewExtension.invokeMiscMethod(
                "setVideoParams",
                data
            )
        }
    }

}