package com.jeffreyliu.core.data.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Owner(@SerialName("avatar_url") val avatarUrl: String? = null)
