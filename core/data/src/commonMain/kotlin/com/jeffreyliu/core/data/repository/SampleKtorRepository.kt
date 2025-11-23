package com.jeffreyliu.core.data.repository

import com.jeffreyliu.core.data.model.QueryResult

interface SampleKtorRepository {
    suspend fun searchGithubRepos(
        query: String,
        sort: String? = null,
        order: String? = null,
    ): Result<QueryResult>
}
