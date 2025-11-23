package com.jeffreyliu.core.data.repository

import kotlinx.coroutines.flow.Flow

interface SampleRepository {
    fun getIntFlow(): Flow<Int>
}
