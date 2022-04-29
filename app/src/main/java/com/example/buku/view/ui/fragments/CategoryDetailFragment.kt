package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buku.R
import com.example.buku.databinding.FragmentCategoryDetailBinding
import com.example.buku.model.Book
import com.example.buku.model.BookList
import com.example.buku.model.Category
import com.example.buku.model.CategoryList
import com.example.buku.view.adapter.BooksAdapter
import com.example.buku.view.ui.activities.MainActivity
import com.google.gson.Gson


class CategoryDetailFragment : Fragment() {

    private lateinit var detailCategoryBinding: FragmentCategoryDetailBinding
    private val args: CategoryDetailFragmentArgs by navArgs()

    private lateinit var listBooksFiltered: ArrayList<Book>
    private lateinit var booksAdapter: BooksAdapter

    //Show top left arrow to go back in the pile
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        detailCategoryBinding = FragmentCategoryDetailBinding.inflate(inflater, container, false)
        return detailCategoryBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val category = args.category

        with(detailCategoryBinding){
            tvCategoryName.text = category.name
        }

    }

}
