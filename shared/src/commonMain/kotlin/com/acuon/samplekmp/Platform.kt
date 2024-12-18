package com.acuon.samplekmp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform