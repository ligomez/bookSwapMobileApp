package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.buku.databinding.FragmentSignUpBinding
import com.example.buku.view.ui.activities.MainActivity
import com.example.buku.viewmodel.SignUpViewModel

class SignUpFragment : Fragment() {

    private lateinit var signUpBinding: FragmentSignUpBinding
    private lateinit var signUpViewModel: SignUpViewModel

    private lateinit var email: String
    private lateinit var name: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (activity as MainActivity?)?.showIcon()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        signUpBinding = FragmentSignUpBinding.inflate(inflater, container, false)
        signUpViewModel = ViewModelProvider(this)[SignUpViewModel::class.java]

        return signUpBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        signUpViewModel.onUserCreated.observe(viewLifecycleOwner) { result ->
            onUserCreatedSubscribe(result)
        }

        signUpViewModel.onUserSignedUp.observe(viewLifecycleOwner) { result ->
            onUserSignedUpSubscribe(result)
        }

        with(signUpBinding) {
            buttonSignUp.setOnClickListener {
                email = emailEditText.text.toString()
                name = nameEditText.text.toString()
                val password = passwordEditText.text.toString()

                signUpViewModel.signUp(email, password)
            }

            buttonSignInCreateAccount.setOnClickListener {
                findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToNavLoginFragment())
            }
        }
    }

    private fun onUserSignedUpSubscribe(result: String?) {
        if (result.equals("User successfully registered"))
            signUpViewModel.createUserAccount(email, name)
        else
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
    }

    private fun onUserCreatedSubscribe(result: String?) {
        Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
        if (result.equals("User successfully created"))
            findNavController().navigate(SignUpFragmentDirections.actionNavSignUpFragmentToNavProfileFragment())
    }
}
