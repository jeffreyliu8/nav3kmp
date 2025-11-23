package com.jeffliu.nav3kmp

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.jeffliu.nav3kmp.di.initKoin

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Nav3Kmp"
    ) {
        initKoin()
        App()
    }
}
