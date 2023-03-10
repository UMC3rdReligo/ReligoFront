package com.UMCfront.religo.src.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.JavascriptInterface
import android.webkit.WebView
import android.webkit.WebViewClient
import com.UMCfront.religo.R

class AddressForKotlin2 : AppCompatActivity() {

    companion object {
        const val ADDRESS_REQUEST_CODE = 2928
    }

    @SuppressLint("SetJavaScriptEnabled", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_address_for_kotlin2)

        val webView = findViewById<WebView>(R.id.web_view)

        webView.settings.javaScriptEnabled = true

        webView.addJavascriptInterface(KaKaoJavaScriptInterface(), "Android")
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView, url: String) {
                webView.loadUrl("javascript:sample2_execDaumPostcode();")
            }
        }

        // Kakao에서 https를 허용하지 않아서 https -> http로 바꿔야 동작함
        webView.loadUrl("https://religoaddress.web.app/")
    }

    inner class KaKaoJavaScriptInterface {

        @JavascriptInterface
        fun processDATA(address: String?) {
            Intent().apply {
                putExtra("address", address)
                setResult(RESULT_OK, this)
            }
            finish()
        }
    }
}