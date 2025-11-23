package com.jeffliu.nav3kmp.viewmodel

import androidx.lifecycle.ViewModel
import com.jeffreyliu.core.data.repository.LoggerRepository

class DetailViewModel(private val logger: LoggerRepository) : ViewModel() {
    init {
        logger.d("Detail ViewModel initializing...")
    }

    override fun onCleared() {
        super.onCleared()
        logger.d("Detail ViewModel clearing...")
    }
}
