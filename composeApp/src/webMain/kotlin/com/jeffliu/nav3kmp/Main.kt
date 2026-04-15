package com.jeffliu.nav3kmp

import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.window.ComposeViewport
import com.jeffliu.nav3kmp.di.initKoin
import eu.anifantakis.lib.ksafe.KSafe
import org.koin.mp.KoinPlatform.getKoin

@OptIn(ExperimentalComposeUiApi::class)
fun main() {
    initKoin()
    ComposeViewport {
        var cacheReady by remember { mutableStateOf(false) }
//        https://github.com/ioannisa/KSafe/blob/main/docs/SETUP.md
        LaunchedEffect(Unit) {
            val ksafe: KSafe = getKoin().get()
            ksafe.awaitCacheReady()
            cacheReady = true
        }

        if (cacheReady) {
            App()
        }
    }
}
