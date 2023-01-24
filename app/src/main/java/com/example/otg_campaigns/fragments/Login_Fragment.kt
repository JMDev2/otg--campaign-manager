@file:Suppress("RedundantNullableReturnType", "UsePropertyAccessSyntax", "UsePropertyAccessSyntax")

package com.example.otg_campaigns.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.otg_campaigns.R
import com.example.otg_campaigns.databinding.FragmentLoginBinding

class Login_Fragment : Fragment() {
    lateinit var binding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentLoginBinding.inflate(inflater, container, false)

        binding.loginButton.setOnClickListener {

            validateUser(binding.loginUsername.getText().toString(), binding.loginPassword.getText().toString())
        }
        return binding.root
    }
    private fun validateUser(userName: String, password: String) {
        if ((userName == "Admin" && password == "1234")) {
            val accountDetailsFragment = AccountDetailsFragment()
            val transaction: FragmentTransaction = parentFragmentManager.beginTransaction()
            transaction.replace(R.id.fragmentContainerView, accountDetailsFragment)
            transaction.commit()
        } else {
            Toast.makeText(requireActivity(), "Failed", Toast.LENGTH_LONG).show()
        }
    }
}
