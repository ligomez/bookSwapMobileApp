package com.example.buku.view.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.buku.R
import com.example.buku.databinding.FragmentSignUpBinding
import com.example.buku.view.ui.activities.MainActivity
import com.example.buku.viewmodel.SignUpViewModel

class SignUpFragment : Fragment() {

    private lateinit var signUpBinding: FragmentSignUpBinding
    private lateinit var signUpViewModel: SignUpViewModel

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
        signUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

        signUpViewModel.onUserCreated.observe(viewLifecycleOwner) { result ->
            onUserCreatedSubscribe(result)
        }

        return signUpBinding.root
    }

    private fun onUserCreatedSubscribe(result: Boolean?) {
        result?.let { isRegistered->
            if (isRegistered) {
                Toast.makeText(context, "Register successful", Toast.LENGTH_SHORT).show()
                findNavController().navigate(SignUpFragmentDirections.actionNavSignUpFragmentToNavProfileFragment())
            } else
                Toast.makeText(context, "Register unsuccessful", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(signUpBinding) {
            buttonSignUp.setOnClickListener {
                val email = emailEditText.text.toString()
                val name = nameEditText.text.toString()
                val password = passwordEditText.text.toString()

                signUpViewModel.signUp(email, password)
            }
            buttonSignInCreateAccount.setOnClickListener {
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToNavLoginFragment())
            }
        }
    }

}