package com.jeffliu.nav3kmp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeffreyliu.core.data.repository.FruitRepository
import com.jeffreyliu.core.data.repository.LoggerRepository
import com.jeffreyliu.core.data.repository.SampleKtorRepository
import com.jeffreyliu.core.data.repository.SampleRepository
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class MainViewModel(
    private val logger: LoggerRepository,
    private val sampleRepository: SampleRepository,
    private val sampleKtorRepository: SampleKtorRepository,
    private val fruitRepository: FruitRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(MainUiState())
    val uiState: StateFlow<MainUiState> = _uiState.asStateFlow()

    init {
        logger.d("MainViewModel init")
        observeFlows()
        testMakeHttpRequest()
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

        fruitRepository.getAllFruits()
            .onEach { history ->
                logger.i("history count is ${history.size}")
            }
            .flowOn(Dispatchers.Default)
            .launchIn(viewModelScope)

        viewModelScope.launch {
            while (true){
                delay(1000)
                fruitRepository.insert("test")
            }
        }
    }

    private fun testMakeHttpRequest() {
        viewModelScope.launch {
            val result = sampleKtorRepository.searchGithubRepos("square")
            if (result.isSuccess) {
                logger.d("HTTP request successful: ${result.getOrNull()?.totalCount}")
            } else {
                logger.e("HTTP request failed: ${result.exceptionOrNull()?.message}")
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        logger.d("MainViewModel onCleared")
    }
}

data class MainUiState(
    val sampleInt: Int = 0,
    val fakeList: ImmutableList<Int> = emptyList<Int>().toImmutableList()
)
