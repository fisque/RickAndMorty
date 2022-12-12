package com.jennywu.rickandmorty.network

import com.jennywu.rickandmorty.network.data.CharactersDTO
import com.jennywu.rickandmorty.network.data.LocationsDTO
import retrofit2.Response

class RickAndMortyService {

    private val retrofit = RetrofitHelper.getInstance()
    private val service = retrofit.create(RickAndMortyApi::class.java)

    suspend fun getCharacters() : Response<CharactersDTO>? {
        return service.getCharacters()
    }

    suspend fun getLocations() : Response<LocationsDTO>? {
        return service.getLocations()
    }

}