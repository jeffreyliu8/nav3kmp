package com.jeffreyliu.database.di

import com.jeffreyliu.database.AppDatabase
import com.jeffreyliu.database.Factory
import org.koin.core.module.Module
import org.koin.dsl.module

actual val dbPlatformModule: Module = module {
    single<AppDatabase?> { Factory().createRoomDatabase() }
}
