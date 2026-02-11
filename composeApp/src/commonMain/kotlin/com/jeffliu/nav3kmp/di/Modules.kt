package com.jeffliu.nav3kmp.di

import com.jeffliu.nav3kmp.viewmodel.DetailViewModel
import com.jeffliu.nav3kmp.viewmodel.HomePaneViewModel
import com.jeffliu.nav3kmp.viewmodel.HomeViewModel
import com.jeffliu.nav3kmp.viewmodel.MainViewModel
import org.koin.dsl.module
import org.koin.plugin.module.dsl.*

// expect val platformModule: Module

val appModule = module {

    viewModel<HomePaneViewModel>()
    viewModel<MainViewModel>()

    viewModel<HomeViewModel>()
    viewModel<DetailViewModel>()
}
