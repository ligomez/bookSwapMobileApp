package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.buku.R
import com.example.buku.databinding.FragmentLogInBinding
import com.example.buku.view.ui.activities.MainActivity


class LogInFragment : Fragment() {

    private lateinit var logInBinding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        logInBinding = FragmentLogInBinding.inflate(inflater, container, false)
        return logInBinding.root
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)
        val btSignUpLogIn: Button = itemView.findViewById(R.id.btSignUpLogin)
        btSignUpLogIn.setOnClickListener { onSignUpButtonClicked() }
        (activity as MainActivity?)?.hideIcon()
    }

    private fun onSignUpButtonClicked() {
        findNavController().navigate(LogInFragmentDirections.actionNavAccountFragmentToSignUpFragment())

    }

}


//    // Get input text
//    val inputText = tilLoginUsername.editText?.text.toString()
//
//    tilLoginUsername.editText?.doOnTextChanged { inputText, _, _, _ ->
//        // Respond to input text change
//    }
