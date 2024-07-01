package models

import kotlinx.serialization.Serializable

@Serializable
data class PokeData(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Result>
)