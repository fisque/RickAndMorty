package com.jennywu.rickandmorty

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jennywu.rickandmorty.databinding.FragmentLocationsBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class LocationsFragment : Fragment() {

    private var _binding: FragmentLocationsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View {

        _binding = FragmentLocationsBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // TODO, like characters fragment!
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}