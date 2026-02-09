package com.jeffreyliu.database.di


import com.jeffreyliu.database.AppDatabase
import com.jeffreyliu.database.FruittieDao
import org.koin.core.module.Module
import org.koin.dsl.module

internal expect val dbPlatformModule: Module


val dbSharedModule = module {
    includes(dbPlatformModule)
    single<FruittieDao> { get<AppDatabase>().fruittieDao() }
}
