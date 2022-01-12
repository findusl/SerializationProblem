package com.example.common

import io.ktor.client.*

expect fun getPlatformName(): String

expect fun getHttpClient(): HttpClient