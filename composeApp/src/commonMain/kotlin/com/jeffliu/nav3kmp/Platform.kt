package com.jeffliu.nav3kmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform