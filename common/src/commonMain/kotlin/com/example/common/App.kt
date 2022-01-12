package com.example.common

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import io.ktor.client.request.*

suspend fun loadJsonSample(): String {
    val totvs = getHttpClient().request<JsonModel>("https://petstore.swagger.io/v2/store/inventory").totvs
    return "Server responded with: $totvs"
}

@Composable
fun App(textToShow: String) {
    Text(textToShow)
}
