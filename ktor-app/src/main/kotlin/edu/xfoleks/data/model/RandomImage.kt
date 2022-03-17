package edu.xfoleks.data.model

import kotlinx.serialization.Serializable

@Serializable
data class RandomImage(
    val name: String,
    val description: String,
    val imageUri: String
)