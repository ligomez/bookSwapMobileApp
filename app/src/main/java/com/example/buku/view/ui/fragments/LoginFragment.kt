package com.example.buku.view.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.buku.R
import com.example.buku.databinding.FragmentLoginBinding
import com.example.buku.utils.isEmailValid
import com.example.buku.view.ui.activities.MainActivity
import com.example.buku.viewmodel.LoginViewModel


class LoginFragment : Fragment() {

    private lateinit var loginBinding: FragmentLoginBinding
    private lateinit var loginViewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false)
        loginViewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        return loginBinding.root
    }


    override fun onViewCreated(itemView: View, savedInstanceState: Bundle?) {
        super.onViewCreated(itemView, savedInstanceState)

        with(loginBinding){
            buttonLogin.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()

                if (email.isEmpty() || password.isEmpty())
                    Toast.makeText(context, "Please enter email and password", Toast.LENGTH_SHORT)
                        .show()
                else
                    if (!isEmailValid(email))
                        Toast.makeText(context, "Please enter right email format", Toast.LENGTH_SHORT)
                            .show()
                    else
                        loginViewModel.login(email, password)
            }
        }

        val btSignUpLogIn: Button = itemView.findViewById(R.id.btSignUpLogin)
        btSignUpLogIn.setOnClickListener { onSignUpButtonClicked() }
        (activity as MainActivity?)?.hideIcon()
    }


    private fun onSignUpButtonClicked() {
        findNavController().navigate(LoginFragmentDirections.actionNavAccountFragmentToSignUpFragment())

    }

}


//    // Get input text
//    val inputText = tilLoginUsername.editText?.text.toString()
//
//    tilLoginUsername.editText?.doOnTextChanged { inputText, _, _, _ ->
//        // Respond to input text change
//    }
