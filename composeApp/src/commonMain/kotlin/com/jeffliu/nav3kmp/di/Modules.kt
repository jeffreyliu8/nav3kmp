package com.jeffliu.nav3kmp.di

import com.jeffliu.nav3kmp.viewmodel.DetailViewModel
import com.jeffliu.nav3kmp.viewmodel.HomePaneViewModel
import com.jeffliu.nav3kmp.viewmodel.HomeViewModel
import com.jeffliu.nav3kmp.viewmodel.MainViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

// expect val platformModule: Module

val appModule = module {

    viewModelOf(::HomePaneViewModel)
    viewModelOf(::MainViewModel)

    viewModelOf(::HomeViewModel)
    viewModelOf(::DetailViewModel)
}
