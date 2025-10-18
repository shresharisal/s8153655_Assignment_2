package com.example.s8153655_assignment2.ui

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.s8153655_assignment2.R
import com.example.s8153655_assignment2.ui.viewmodel.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val vm: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) // create a simple layout

        val usernameEt = findViewById<EditText>(R.id.usernameEt)
        val passwordEt = findViewById<EditText>(R.id.passwordEt)
        val locationEt = findViewById<EditText>(R.id.locationEt)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val outputTv = findViewById<TextView>(R.id.outputTv)

        loginBtn.setOnClickListener {
            val username = usernameEt.text.toString()
            val password = passwordEt.text.toString()
            val location = locationEt.text.toString()
            vm.loginUser(username, password, location)
        }

        vm.loginResult.observe(this, Observer { keypass ->
            outputTv.text = "Keypass: $keypass"
            keypass?.let { vm.loadDashboard(it) }
        })

        vm.dashboardData.observe(this, Observer { list ->
            outputTv.text = "Dashboard items: ${list?.size ?: 0}"
        })

        vm.errorMessage.observe(this, Observer { err ->
            err?.let { outputTv.text = it }
        })
    }
}
