package com.jeffliu.nav3kmp.viewmodel

import androidx.lifecycle.ViewModel
import com.jeffreyliu.core.data.repository.LoggerRepository


class HomeViewModel(
    private val logger: LoggerRepository,
) : ViewModel() {
    init {
        logger.d("Home ViewModel initializing...")
    }

    override fun onCleared() {
        super.onCleared()
        logger.d("Home ViewModel clearing...")
    }
}