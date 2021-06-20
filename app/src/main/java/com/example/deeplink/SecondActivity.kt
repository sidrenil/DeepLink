package com.example.deeplink


import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity


class SecondActivity: AppCompatActivity() {

    private lateinit var webV: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.web_view)

        val site = intent.getParcelableExtra<DataClass>("siteUrl")

        webV = findViewById(R.id.webV)
        webV.settings.javaScriptEnabled = true
        webV.settings.setSupportZoom(true)
        webV.settings.builtInZoomControls = true
        webV.settings.displayZoomControls = false
        webV.loadUrl(site!!.siteUrl)

        webV.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return false
            }
        }
    }

    override fun onBackPressed() {
        if (webV.canGoBack()) {
            webV.goBack()
        } else {
            super.onBackPressed()
        }
    }
}