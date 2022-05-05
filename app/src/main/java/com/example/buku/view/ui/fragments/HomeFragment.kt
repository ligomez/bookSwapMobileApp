package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.buku.databinding.FragmentHomeBinding
import com.example.buku.model.Book
import com.example.buku.model.Category
import com.example.buku.view.adapter.BooksAdapter
import com.example.buku.view.adapter.CategoriesAdapter
import com.example.buku.view.ui.activities.MainActivity
import com.example.buku.viewmodel.HomeViewModel


class HomeFragment : Fragment() {

    private lateinit var homeBinding: FragmentHomeBinding
    private val homeViewModel: HomeViewModel by viewModels()

    private lateinit var listBooks: ArrayList<Book>
    private lateinit var booksAdapter: BooksAdapter

    private lateinit var listCategories: ArrayList<Category>
    private lateinit var categoriesAdapter: CategoriesAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        homeBinding = FragmentHomeBinding.inflate(inflater, container, false)

        // Communicates Fragment with ViewModel if I don't add by viewModels()
//        homeViewModel = ViewModelProvider(this)[HomeViewModel::class.java]

        return homeBinding.root
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        //Hide top left arrow to go back in the pile
        (activity as MainActivity?)?.hideIcon()

        homeViewModel.loadMockBooksFromJason(context?.assets?.open("books.json"))

        homeViewModel.onBooksLoaded.observe(viewLifecycleOwner) { result ->
            onBooksLoadedSubscribe(result)
        }

        listCategories = context?.let { homeViewModel.loadMockCategoriesFromJason(it) }!!
        categoriesAdapter = CategoriesAdapter(listCategories, onItemClicked = { onCategoryClicked(it)})

        homeBinding.rvCategoriesHome.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.HORIZONTAL, false)
            adapter = categoriesAdapter
            setHasFixedSize(false)
        }
    }

    private fun onBooksLoadedSubscribe(listBooks: ArrayList<Book>?) {
        booksAdapter = BooksAdapter(listBooks!!, onItemClicked = { onBookClicked(it)})

        homeBinding.rvBooksHome.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = booksAdapter
            setHasFixedSize(false)
        }
    }


    private fun onBookClicked(book: Book) {
        findNavController().navigate(HomeFragmentDirections.actionNavHomeFragmentToBookDetailFragment(book))
    }


    private fun onCategoryClicked(category: Category) {
        findNavController().navigate(HomeFragmentDirections.actionNavHomeFragmentToCategoryDetailFragment(category))
    }

}