package com.example.common

import kotlinx.serialization.Serializable

@Serializable
data class JsonModel(
	val totvs: Int
)

fun `This method call shows an error in Intellj IDEA but compiles just fine`() {
	JsonModel.serializer()
}
