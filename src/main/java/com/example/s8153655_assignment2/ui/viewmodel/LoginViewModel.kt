package com.example.s8153655assignment2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s8153655assignment2.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loginResult = MutableStateFlow<String?>(null)
    val loginResult = _loginResult.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading = _isLoading.asStateFlow()

    fun login(username: String, password: String, location: String) {
        viewModelScope.launch {
            _isLoading.value = true
            val key = loginUseCase(username, password, location)
            _loginResult.value = key
            _isLoading.value = false
        }
    }

    fun resetLoginResult() {
        _loginResult.value = null
    }
}
