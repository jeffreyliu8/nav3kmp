package com.jeffliu.nav3kmp.di

import com.jeffliu.nav3kmp.viewmodel.DetailViewModel
import com.jeffliu.nav3kmp.viewmodel.HomePaneViewModel
import com.jeffliu.nav3kmp.viewmodel.HomeViewModel
import com.jeffliu.nav3kmp.viewmodel.MainViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

// expect val platformModule: Module

val appModule = module {

//    viewModel<HomePaneViewModel>()
//    viewModel<MainViewModel>()
//
//    viewModel<HomeViewModel>()
//    viewModel<DetailViewModel>() //was used in 0.3.0

    viewModel { HomePaneViewModel(get(), get()) }
    viewModel { MainViewModel(get(), get(), get(), get(), get()) }
    viewModel { HomeViewModel(get()) }
    viewModel { DetailViewModel(get()) }
}
