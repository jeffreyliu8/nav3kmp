package com.jeffliu.nav3kmp

import androidx.compose.ui.window.ComposeUIViewController
import com.jeffliu.nav3kmp.di.initKoin

fun mainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) { App() }
