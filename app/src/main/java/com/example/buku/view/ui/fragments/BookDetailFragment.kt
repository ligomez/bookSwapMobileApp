package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.buku.databinding.FragmentBookDetailBinding
import com.example.buku.view.ui.activities.MainActivity
import com.squareup.picasso.Picasso

class BookDetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentBookDetailBinding
    private val args: BookDetailFragmentArgs by navArgs()

    //Show top left arrow to go back in the pile
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        detailBinding = FragmentBookDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val book = args.book

        with(detailBinding) {
            tvNameBook.text = book.name
            tvAuthorBook.text = book.author
            Picasso.get().load(book.imageUrl).into(ivBookImage)
            tvBookParagraphDetails.text = book.details
            tvBookCondition.text = book.condition
            tvLocation.text = book.location
            tvUserName.text = book.postedBy

        }

    }
}
