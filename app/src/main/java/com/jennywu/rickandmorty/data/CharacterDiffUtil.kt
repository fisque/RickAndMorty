package com.jennywu.rickandmorty.data

import androidx.recyclerview.widget.DiffUtil

class CharacterDiffUtil : DiffUtil.ItemCallback<CharacterItem>() {
    override fun areItemsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean {
        return oldItem.id == newItem.id
    }
}