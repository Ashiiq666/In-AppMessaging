package com.onesignal.in_appmessaging.app

import android.app.Application
import com.onesignal.OneSignal
import com.onesignal.in_appmessaging.R

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.NONE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(getString(R.string.ONESIGNAL_APP_ID))


    }

}
