package com.jeffreyliu.core.data.repository

import com.jeffreyliu.core.data.model.MyFruit
import kotlinx.coroutines.flow.Flow

interface SharedPrefRepository {
    suspend fun saveUserProfile(message: String)
    fun getUserProfile(): Flow<String>
}
