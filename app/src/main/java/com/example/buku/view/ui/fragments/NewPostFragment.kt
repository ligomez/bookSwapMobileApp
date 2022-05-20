package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.buku.databinding.FragmentNewPostBinding


class NewPostFragment : Fragment() {

    private lateinit var newPostBinding: FragmentNewPostBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        newPostBinding = FragmentNewPostBinding.inflate(inflater,container,false)
        return newPostBinding.root
    }

}



