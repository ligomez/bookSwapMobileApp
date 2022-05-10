package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.buku.R
import com.example.buku.databinding.FragmentBookDetailBinding
import com.example.buku.view.ui.activities.MainActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.MarkerOptions
import com.squareup.picasso.Picasso

class BookDetailFragment : Fragment() {

    private lateinit var detailBinding: FragmentBookDetailBinding
    private val args: BookDetailFragmentArgs by navArgs()

    private val callback = OnMapReadyCallback { googleMap ->
        val book = args.book
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

        // Setting location map
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment?
        mapFragment?.getMapAsync(callback)

    }
}
