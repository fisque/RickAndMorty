package com.jennywu.rickandmorty

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jennywu.rickandmorty.data.CharacterItem
import com.jennywu.rickandmorty.data.CharactersViewState
import com.jennywu.rickandmorty.databinding.FragmentCharactersBinding
import com.jennywu.rickandmorty.network.RickAndMortyService

/**
 * Fragment for displaying a list of Rick And Morty characters
 */
class CharactersFragment : Fragment() {

    private lateinit var viewModel: CharactersViewModel
    private lateinit var repo: CharactersRepo
    private lateinit var service: RickAndMortyService

    private var _binding: FragmentCharactersBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: CharactersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharactersBinding.inflate(inflater, container, false)

        adapter = CharactersAdapter()
        service = RickAndMortyService()
        repo = CharactersRepo(service)
        viewModel = CharactersViewModel(repo)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeState()
    }

    private fun observeState() {
        viewModel.state.observe(viewLifecycleOwner) {
            when (it) {
                CharactersViewState.Loading -> showLoading()
                CharactersViewState.Error -> showError()
                is CharactersViewState.Content -> showContent(it.characters)
            }
        }
    }

    private fun showLoading() {
        binding.loadingSpinner.visibility = View.VISIBLE
        binding.charactersList.visibility = View.GONE
        binding.errorText.visibility = View.GONE
    }

    private fun showError() {
        binding.loadingSpinner.visibility = View.GONE
        binding.charactersList.visibility = View.GONE
        binding.errorText.visibility = View.VISIBLE
    }

    private fun showContent(characters: List<CharacterItem>) {
        binding.loadingSpinner.visibility = View.GONE
        binding.charactersList.visibility = View.VISIBLE
        binding.errorText.visibility = View.GONE

        adapter.submitList(characters)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}