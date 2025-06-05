package com.example.web

import android.webkit.WebView
import android.webkit.WebViewClient

class webviewclient: WebViewClient() {
    override fun shouldOverrideUrlLoading(view: WebView?, url: String?): Boolean {
        return super.shouldOverrideUrlLoading(view, url)
    }
}