package com.jeffreyliu.core.data.repository

interface LoggerRepository {
    fun i(message: String)
    fun v(message: String)
    fun d(message: String)
    fun e(message: String)
}
