package com.jeffliu.nav3kmp.di

import com.jeffreyliu.core.data.di.sharedModule
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration

fun initKoin(config: KoinAppDeclaration? = null) {
    startKoin {
        config?.invoke(this)
        modules(
            appModule,
            sharedModule
//            platformModule,
        )
    }
}
