package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import com.example.buku.R
import com.example.buku.databinding.FragmentFavoritesBinding
import com.example.buku.viewmodel.FavoritesViewModel


class FavoritesFragment : Fragment() {

    private lateinit var favoritesBinding: FragmentFavoritesBinding
    private val favoritesViewModel: FavoritesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        favoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return favoritesBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        favoritesViewModel.getFavoriteBooks()
    }

}