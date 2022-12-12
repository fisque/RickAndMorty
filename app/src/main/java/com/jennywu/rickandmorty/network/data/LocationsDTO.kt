package com.jennywu.rickandmorty.network.data

import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class LocationsDTO(
    val info: LocationsInfo,
    val results: List<LocationResult>
)

@Serializable
data class LocationsInfo(
    val count: Long,
    val pages: Long,
    val next: String?,
    val previous: String?,
)

@Serializable
data class LocationResult(
    val id: Int,
    val name: String,
    val type: String,
    val dimension: String,
    val residents: List<String>,
    val url: String,
    val created: Date
)