package models


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class test(
    @SerialName("name")
    val name: String
)