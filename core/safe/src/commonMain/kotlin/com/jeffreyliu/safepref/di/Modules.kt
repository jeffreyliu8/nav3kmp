package com.jeffreyliu.safepref.di


import org.koin.core.module.Module
import org.koin.dsl.module


// common
internal expect val platformModule: Module

val kSafeSharedModule = module {
    includes(platformModule)
}
