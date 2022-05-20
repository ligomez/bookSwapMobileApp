package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.buku.R
import com.example.buku.databinding.FragmentBookDetailBinding
import com.example.buku.model.Book
import com.example.buku.view.ui.activities.MainActivity
import com.example.buku.viewmodel.BookDetailViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso

class BookDetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentBookDetailBinding
    private val bookDetailViewModel: BookDetailViewModel by viewModels()
    private val args: BookDetailFragmentArgs by navArgs()
    private lateinit var book: Book

    private val callback = OnMapReadyCallback { googleMap ->
        book = args.book
        val latitude = book.latitude
        val longitude = book.longitude
        val mapLocation = com.google.android.gms.maps.model.LatLng(latitude, longitude)
        googleMap.addMarker(
            MarkerOptions()
                .position(mapLocation)
                .title(getString(R.string.marker_title)))
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(mapLocation, 15f))
    }

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
        detailBinding = FragmentBookDetailBinding.inflate(inflater, container, false)
        return detailBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        book = args.book

        with(detailBinding) {
            tvNameBook.text = book.name
            tvAuthorBook.text = book.author
            Picasso.get().load(book.imageUrl).into(ivBookImage)
            tvBookParagraphDetails.text = book.details
            tvBookCondition.text = book.condition
            tvLocation.text = book.location
            tvUserName.text = book.postedBy

            ivFavorite.setOnClickListener{
                bookDetailViewModel.saveInFavorites(book)
            }

        }

        // Setting location map
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)
    }
}
