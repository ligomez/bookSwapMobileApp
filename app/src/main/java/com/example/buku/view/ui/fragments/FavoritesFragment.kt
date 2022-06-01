package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buku.data.local.BookLocal
import com.example.buku.databinding.FragmentFavoritesBinding
import com.example.buku.view.adapter.FavoritesAdapter
import com.example.buku.viewmodel.FavoritesViewModel

class FavoritesFragment : Fragment() {

    private lateinit var favoritesBinding: FragmentFavoritesBinding
    private val favoritesViewModel: FavoritesViewModel by viewModels()
    private lateinit var favoritesAdapter: FavoritesAdapter
    private var favoriteBooksList: ArrayList<BookLocal> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        favoritesBinding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return favoritesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        favoritesBinding.pbFavorites.visibility = View.VISIBLE
        favoritesViewModel.getFavoriteBooks()

        favoritesViewModel.onBooksLoaded.observe(viewLifecycleOwner) { result ->
            onBooksLoadedSubscribe(result)
        }
        favoritesAdapter = FavoritesAdapter(favoriteBooksList, onItemClicked = {
            onFavoriteBookClicked(it)
        })

        favoritesBinding.rvFavorites.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = favoritesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onFavoriteBookClicked(book: BookLocal) {
        TODO("Not yet implemented")
    }

    private fun onBooksLoadedSubscribe(result: MutableList<BookLocal>?) {
        result?.let { listFavoriteBooks ->
            favoritesAdapter.appendItems(listFavoriteBooks as ArrayList<BookLocal>)
        }
    }

// Cuando los datos carguen
//    favoritesBinding.pbFavorites.visibility = View.INVISIBLE
}