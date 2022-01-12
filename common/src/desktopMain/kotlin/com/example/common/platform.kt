package com.example.common

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json

actual fun getPlatformName(): String {
	return "Desktop"
}

actual fun getHttpClient(): HttpClient {
	return HttpClient(CIO) {
		install(JsonFeature) {
			serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
				isLenient = true
				ignoreUnknownKeys = true
				explicitNulls = false
				encodeDefaults = false
			})
		}
	}
}