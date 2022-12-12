package com.jennywu.rickandmorty.data

sealed class CharactersViewState {

    object Loading : CharactersViewState()

    object Error : CharactersViewState()

    data class Content(
        val characters: List<CharacterItem>
    ) : CharactersViewState()

}