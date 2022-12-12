package com.jennywu.rickandmorty

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.jennywu.rickandmorty.data.CharacterDiffUtil
import com.jennywu.rickandmorty.data.CharacterItem
import com.jennywu.rickandmorty.databinding.ListItemCharacterBinding

class CharactersAdapter:
    ListAdapter<CharacterItem, CharacterItemViewHolder>(CharacterDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = ListItemCharacterBinding.inflate(inflater, parent, false)
        return CharacterItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterItemViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}