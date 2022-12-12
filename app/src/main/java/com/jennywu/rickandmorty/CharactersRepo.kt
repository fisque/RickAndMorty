package com.jennywu.rickandmorty

import com.jennywu.rickandmorty.data.CharacterItem
import com.jennywu.rickandmorty.data.CharactersRepoState
import com.jennywu.rickandmorty.network.RickAndMortyApi
import com.jennywu.rickandmorty.network.RickAndMortyService
import com.jennywu.rickandmorty.network.data.CharactersDTO
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class CharactersRepo(
    private val service: RickAndMortyService
) {

    private val _repoState = MutableStateFlow<CharactersRepoState>(CharactersRepoState.Error)
    val repoState: StateFlow<CharactersRepoState> = _repoState

    suspend fun getCharacters() {
        val result = service.getCharacters()
        if (result != null) {
            _repoState.value = CharactersRepoState.Success(
                result.body().toCharacterItems()
            )
        } else {
            _repoState.value = CharactersRepoState.Error
        }
    }

}

private fun CharactersDTO?.toCharacterItems() : List<CharacterItem> {
    return if (this == null) {
        listOf()
    } else {
        val charactersList = mutableListOf<CharacterItem>()
        for (item in results) {
            charactersList.add(
                CharacterItem(
                    id = item.id,
                    profile = item.image,
                    name = item.name,
                    status = item.status
                )
            )
        }
        charactersList
    }
}