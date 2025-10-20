package com.example.s8153655assignment2.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.s8153655_assignment2.R
import com.example.s8153655assignment2.ui.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main) {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val usernameEt = findViewById<EditText>(R.id.usernameEt)
        val passwordEt = findViewById<EditText>(R.id.passwordEt)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        viewModel.loginResult.observe(this) { key ->
            if (key != null) {
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("keypass", key)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login failed!", Toast.LENGTH_SHORT).show()
            }
        }

        loginBtn.setOnClickListener {
            val user = usernameEt.text.toString()
            val pass = passwordEt.text.toString()
            if (user.isBlank() || pass.isBlank()) {
                Toast.makeText(this, "Fill in both fields", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.login(user, pass, "footscray")
            }
        }
    }
}

