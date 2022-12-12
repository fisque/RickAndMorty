package com.jennywu.rickandmorty.network.data

import com.jennywu.rickandmorty.data.Gender
import com.jennywu.rickandmorty.data.Species
import com.jennywu.rickandmorty.data.Status
import kotlinx.serialization.Serializable
import java.util.Date

@Serializable
data class CharactersDTO(
    val info: CharactersInfo,
    val results: List<CharacterResult>
)

@Serializable
data class CharactersInfo(
    val count: Long,
    val pages: Long,
    val next: String?,
    val previous: String?
)

@Serializable
data class CharacterResult(
    val id: Int,
    val name: String,
    val status: Status,
    val species: Species,
    val type: String = "",
    val gender: Gender,
    val origin: Origin,
    val location: Location,
    val image: String,
    val episode: List<String>,
    val url: String,
    val created: Date
)

@Serializable
data class Origin(
    val name: String,
    val url: String = ""
)

@Serializable
data class Location(
    val name: String,
    val url: String
)