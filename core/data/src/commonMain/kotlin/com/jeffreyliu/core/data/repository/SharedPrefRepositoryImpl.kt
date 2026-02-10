package com.jeffreyliu.core.data.repository

import eu.anifantakis.lib.ksafe.KSafe
import kotlinx.coroutines.flow.Flow

internal class SharedPrefRepositoryImpl(private val kSafe: KSafe) : SharedPrefRepository {
    companion object {
        private const val SHARED_PREF_KEY_USER_PROFILE = "profile"
    }

    override suspend fun saveUserProfile(message: String) {
        kSafe.put(SHARED_PREF_KEY_USER_PROFILE, message)
    }

    override fun getUserProfile(): Flow<String> = kSafe.getFlow(SHARED_PREF_KEY_USER_PROFILE, "")
}
