package com.jeffreyliu.core.data.repository

import kotlinx.coroutines.flow.Flow

interface SharedPrefRepository {
    suspend fun saveUserProfile(message: String)
    fun getUserProfile(): Flow<String>
}
