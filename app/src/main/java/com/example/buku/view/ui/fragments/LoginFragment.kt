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

        loginViewModel.onUserLoggedin.observe(viewLifecycleOwner) { result ->
            onUserLoggedinSubscribe(result)
        }

        loginViewModel.onUserLoginChecked.observe(viewLifecycleOwner) { result ->
            onUserLoggedinCheckedSubscribe(result)
        }

        return loginBinding.root
    }

    private fun onUserLoggedinCheckedSubscribe(result: Boolean?) {
        result?.let { isUserLoggedinChecked ->
            if (isUserLoggedinChecked)
                findNavController().navigate(LoginFragmentDirections.actionNavAccountFragmentToFragmentProfile())
        }
    }


    private fun onUserLoggedinSubscribe(result: Boolean?) {
        result?.let { isLoggedin ->
            if (isLoggedin) {
                findNavController().navigate(LoginFragmentDirections.actionNavAccountFragmentToFragmentProfile())
            } else
                Toast.makeText(context, "Log in unsuccessful, please try again later", Toast.LENGTH_SHORT).show()
        }
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

            btSignUpLogin.setOnClickListener { onSignUpButtonClicked() }

            (activity as MainActivity?)?.hideIcon()
        }

        checkUserLoggedin()
    }


    private fun checkUserLoggedin() {
        loginViewModel.checkUserLoggedin()
    }


    private fun onSignUpButtonClicked() {
        findNavController().navigate(LoginFragmentDirections.actionNavAccountFragmentToSignUpFragment())
    }
}

