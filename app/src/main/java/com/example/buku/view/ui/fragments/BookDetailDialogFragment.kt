package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.buku.R
import com.example.buku.databinding.FragmentBookDetailDialogBinding
import com.example.buku.model.Books
import com.squareup.picasso.Picasso

class BookDetailDialogFragment : DialogFragment() {

    private var _binding: FragmentBookDetailDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookDetailDialogBinding.inflate(inflater,container,false)
        var view = binding.root
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val books = arguments?.getSerializable("book") as Books

        binding.tvNameBook.text = books.name
        binding.tvAuthorBook.text = books.author
        binding.tvLocation.text = books.location
        Picasso.get().load(books.imageUrl).into(binding.ivBookImage)

        binding.btVerMas.setOnClickListener {
            dismiss()
        }
    }

    override fun onStart() {
        super.onStart()
        dialog?.window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.MATCH_PARENT)
    }

}