package com.jeffreyliu.core.data.repository

import com.jeffreyliu.core.data.model.MyFruit
import kotlinx.coroutines.flow.Flow

interface FruitRepository {
    suspend fun insert(message: String)
    fun getAllFruits(): Flow<List<MyFruit>>
}
