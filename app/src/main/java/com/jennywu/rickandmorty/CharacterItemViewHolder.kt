package com.jennywu.rickandmorty

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jennywu.rickandmorty.data.CharacterItem
import com.jennywu.rickandmorty.databinding.ListItemCharacterBinding

/**
 * ViewHolder for a [CharacterItem] in the characters list
 */
class CharacterItemViewHolder(
    private val binding: ListItemCharacterBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(character: CharacterItem) {
        binding.name.text = character.name
        binding.status.text = character.status.label
        Glide.with(binding.profile)
            .load(character.profile)
            .into(binding.profile)
    }

}