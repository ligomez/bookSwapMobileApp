package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.buku.databinding.FragmentBookDetailBinding
import com.example.buku.model.Book

class BookDetailFragment : Fragment() {

    private var _binding: FragmentBookDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookDetailBinding.inflate(inflater,container,false)
        var view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val books = arguments?.getSerializable("book") as Book

        binding.tvNameBook.text = books.name
        binding.tvAuthorBook.text = books.author
        binding.tvLocation.text = books.location
//        Picasso.get().load(books.imageUrl).into(binding.ivBookImage)

        binding.btVerMas.setOnClickListener {

        }
    }

}