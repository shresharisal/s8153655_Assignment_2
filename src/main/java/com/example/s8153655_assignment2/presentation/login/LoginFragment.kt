package com.example.s8153655assignment2.presentation.login

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.s8153655_assignment2.R
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class LoginFragment : Fragment(R.layout.fragment_login) {

    private val vm: LoginViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val edtUsername = view.findViewById<EditText>(R.id.edtUsername)
        val edtPassword = view.findViewById<EditText>(R.id.edtPassword)
        val btnLogin = view.findViewById<Button>(R.id.btnLogin)

        vm.loginResult.observe(viewLifecycleOwner) { key ->
            if (key != null) {
                // navigate to dashboard, pass keypass in bundle
                val b = bundleOf("keypass" to key)
                findNavController().navigate(R.id.action_to_dashboard, b)
            } else {
                Toast.makeText(requireContext(), "Login failed. Check credentials.", Toast.LENGTH_SHORT).show()
            }
        }

        btnLogin.setOnClickListener {
            val user = edtUsername.text.toString()
            val pass = edtPassword.text.toString()
            if (user.isBlank() || pass.isBlank()) {
                Toast.makeText(requireContext(), "Please fill in both fields", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            // Use "footscray" (or br/sydney) depending on your class — spec says use your class location
            vm.login(user, pass, "footscray")
        }
    }
}
