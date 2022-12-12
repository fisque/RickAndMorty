package com.jennywu.rickandmorty.data

sealed class CharactersRepoState {

    data class Success(
        val characters: List<CharacterItem>
    ): CharactersRepoState()

    object Error : CharactersRepoState()

}
