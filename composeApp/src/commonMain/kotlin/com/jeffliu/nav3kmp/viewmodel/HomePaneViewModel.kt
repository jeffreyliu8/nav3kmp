package com.jeffliu.nav3kmp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeffreyliu.core.data.repository.LoggerRepository
import com.jeffreyliu.core.data.repository.SampleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update

class HomePaneViewModel(
    private val logger: LoggerRepository,
    private val sampleRepository: SampleRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(HomePaneUiState())
    val uiState: StateFlow<HomePaneUiState> = _uiState.asStateFlow()

    init {
        logger.d("HomePaneViewModel init")
        observeFlows()
    }

    private fun observeFlows() {
        sampleRepository.getIntFlow()
            .onEach { history ->
                _uiState.update {
                    it.copy(
                        sampleInt = history
                    )
                }
            }
            .flowOn(Dispatchers.Default)
            .launchIn(viewModelScope)
    }

    override fun onCleared() {
        super.onCleared()
        logger.d("HomePaneViewModel onCleared")
    }
}

data class HomePaneUiState(val sampleInt: Int = 0)
