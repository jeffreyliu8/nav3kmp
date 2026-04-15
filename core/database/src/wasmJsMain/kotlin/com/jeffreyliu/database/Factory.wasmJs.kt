package com.jeffreyliu.database

import androidx.room3.Room
import androidx.sqlite.driver.web.WebWorkerSQLiteDriver
import org.w3c.dom.Worker

actual class Factory {
    actual fun createRoomDatabase(): AppDatabase = Room.inMemoryDatabaseBuilder<AppDatabase>()
        .setDriver(WebWorkerSQLiteDriver(jsWorker()))
        .build()
}

@OptIn(ExperimentalWasmJsInterop::class)
private fun jsWorker(): Worker =
    js("""new Worker(new URL("sqlite-wasm-worker/worker.js", import.meta.url))""")