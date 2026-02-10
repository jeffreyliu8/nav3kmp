package com.jeffreyliu.core.data.di

import com.jeffreyliu.core.data.repository.FruitRepository
import com.jeffreyliu.core.data.repository.FruitRepositoryImpl
import com.jeffreyliu.core.data.repository.LoggerRepository
import com.jeffreyliu.core.data.repository.LoggerRepositoryImpl
import com.jeffreyliu.core.data.repository.SampleKtorRepository
import com.jeffreyliu.core.data.repository.SampleKtorRepositoryImpl
import com.jeffreyliu.core.data.repository.SampleRepository
import com.jeffreyliu.core.data.repository.SampleRepositoryImpl
import com.jeffreyliu.core.data.repository.SharedPrefRepository
import com.jeffreyliu.core.data.repository.SharedPrefRepositoryImpl
import com.jeffreyliu.database.di.dbSharedModule
import com.jeffreyliu.safepref.di.kSafeSharedModule
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.dsl.module

// expect val platformModule: Module

val sharedModule = module {
    includes(dbSharedModule)
    includes(kSafeSharedModule)
//    singleOf(::AlarmControlRepository)
//    single<FirebaseDatabaseRepository> { FirebaseDatabaseRepositoryImpl() }
//    single<DeviceActionRepository> { DeviceActionRepositoryImpl(get(), get(),get()) }
    single<SampleRepository> { SampleRepositoryImpl() }
    single<LoggerRepository> { LoggerRepositoryImpl() }
    single {
        HttpClient {
            install(ContentNegotiation) {
                json(
                    Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    }
                )
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        co.touchlab.kermit.Logger.v(message, null, "ktor")
                    }
                }
                level = LogLevel.HEADERS
            }
        }
    }
    single<SampleKtorRepository> { SampleKtorRepositoryImpl(get(), get()) }

    single<FruitRepository> { FruitRepositoryImpl(get()) }

    single<SharedPrefRepository> { SharedPrefRepositoryImpl(get()) }
}
