package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import com.example.buku.R
import com.example.buku.databinding.FragmentSignUpBinding
import com.example.buku.view.ui.activities.MainActivity

class SignUpFragment : Fragment() {

    private lateinit var signUpBinding: FragmentSignUpBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        signUpBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        return signUpBinding.root
    }

//    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(itemView, savedInstanceState)
////        val btSignInCreateAccount: Button = itemView.findViewById(R.id.btSignInCreateAccount)
////        btSignInCreateAccount.setOnClickListener { onSignInButtonClicked() }
//    }

}