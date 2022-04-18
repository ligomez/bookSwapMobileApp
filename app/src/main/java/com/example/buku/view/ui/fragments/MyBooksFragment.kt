package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.buku.R
import com.example.buku.databinding.FragmentMyBooksBinding
import com.example.buku.model.Book
import com.example.buku.view.adapter.BooksAdapter
import com.example.buku.view.adapter.BooksListener
import com.example.buku.viewmodel.OrderViewModel


class MyBooksFragment : Fragment(), BooksListener {

    private var _binding: FragmentMyBooksBinding? = null
    private val binding get() = _binding!!

    private lateinit var booksAdapter: BooksAdapter
    private lateinit var orderViewModel: OrderViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentMyBooksBinding.inflate(inflater,container,false)
        val view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        orderViewModel = ViewModelProvider(this).get(OrderViewModel::class.java)
        orderViewModel.refresh()

        booksAdapter = BooksAdapter(this)

        binding.rvBooks.apply {
            layoutManager = LinearLayoutManager(view.context, LinearLayoutManager.VERTICAL,
                false)

            adapter = booksAdapter
        }

        observeViewModel()
    }

    fun observeViewModel() {
        orderViewModel.listBooks.observe(viewLifecycleOwner, Observer<List<Book>> {
            books ->
            booksAdapter.updateData(books)
        })

        orderViewModel.isLoading.observe(viewLifecycleOwner, Observer<Boolean> {
            if (it != null)
                binding.rlBaseMyBooks.visibility = View.INVISIBLE
        })
    }

    override fun onBooksClick(book: Book, position: Int) {
        val bundle = bundleOf("book" to book)
        findNavController().navigate(R.id.bookDetailDialogFragment, bundle)
    }

}