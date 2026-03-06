package com.jeffreyliu.core.data.repository

import co.touchlab.kermit.Logger

internal class LoggerRepositoryImpl : LoggerRepository {
    private val tag = "kmpLog"
    override fun i(message: String) {
        Logger.i(tag = tag) { message }
    }

    override fun v(message: String) {
        Logger.v(tag = tag) { message }
    }

    override fun d(message: String) {
        Logger.d(tag = tag) { message }
    }

    override fun e(message: String) {
        Logger.e(tag = tag) { message }
    }
}
