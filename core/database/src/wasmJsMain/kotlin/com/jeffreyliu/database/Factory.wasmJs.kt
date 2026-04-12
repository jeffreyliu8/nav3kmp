package com.jeffreyliu.database

import androidx.room3.Room
import kotlinx.coroutines.Dispatchers

actual class Factory {
    actual fun createRoomDatabase(): AppDatabase {
        return Room.databaseBuilder<AppDatabase>(
            name = "todo some name fix me"
        )
            .setQueryCoroutineContext(Dispatchers.Default) // todo fix me
            .build()
    }
}