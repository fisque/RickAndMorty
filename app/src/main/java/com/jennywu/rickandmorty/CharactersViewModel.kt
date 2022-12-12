package com.jennywu.rickandmorty

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jennywu.rickandmorty.data.CharactersRepoState
import com.jennywu.rickandmorty.data.CharactersViewState
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class CharactersViewModel(
    private val repo: CharactersRepo
): ViewModel() {

    private val _state = MutableLiveData<CharactersViewState>()
    val state: LiveData<CharactersViewState> = _state

    init {
        getCharacters()

        observeRepo()
    }

    private fun getCharacters() {
        _state.postValue(CharactersViewState.Loading)
        viewModelScope.launch {
            repo.getCharacters()
        }
    }

    private fun observeRepo() {
        viewModelScope.launch {
            repo.repoState.collect {
                when (it) {
                    CharactersRepoState.Error -> {
                        _state.postValue(CharactersViewState.Error)
                    }
                    is CharactersRepoState.Success -> {
                        _state.postValue(CharactersViewState.Content(it.characters))
                    }
                }
            }
        }
    }

}