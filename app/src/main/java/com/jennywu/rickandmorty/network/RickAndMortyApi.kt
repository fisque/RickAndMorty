package com.jennywu.rickandmorty.network

import com.jennywu.rickandmorty.network.data.CharactersDTO
import com.jennywu.rickandmorty.network.data.LocationsDTO
import retrofit2.Response
import retrofit2.http.GET

interface RickAndMortyApi {

    @GET("character")
    suspend fun getCharacters() : Response<CharactersDTO>?

    @GET("location")
    suspend fun getLocations() : Response<LocationsDTO>?

}