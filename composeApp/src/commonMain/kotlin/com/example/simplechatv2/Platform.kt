package com.example.simplechatv2

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform