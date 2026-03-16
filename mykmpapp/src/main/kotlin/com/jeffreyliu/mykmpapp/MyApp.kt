package com.jeffreyliu.mykmpapp

import android.app.Application
import com.jeffliu.nav3kmp.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.annotation.KoinApplication
import org.koin.core.component.KoinComponent

@KoinApplication
class MyApp :
    Application(),
    KoinComponent {
    override fun onCreate() {
        super.onCreate()
        initKoin {
            androidLogger()
            androidContext(this@MyApp)
        }
    }
}
