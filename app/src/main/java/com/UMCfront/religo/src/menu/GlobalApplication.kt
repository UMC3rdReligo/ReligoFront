package com.UMCfront.religo.src.menu
import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.UMCfront.religo.R


class GlobalApplication:Application() {
    override fun onCreate() {
        super.onCreate()
        KakaoSdk.init(this, "c5a5df86d7f63c928abd4daa3ec3d59a")
    }
}