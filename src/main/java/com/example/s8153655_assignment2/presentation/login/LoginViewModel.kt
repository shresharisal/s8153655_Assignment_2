package com.example.s8153655assignment2.presentation.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s8153655assignment2.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _loginResult = MutableLiveData<String?>()
    val loginResult: LiveData<String?> = _loginResult

    fun login(username: String, password: String, location: String) {
        viewModelScope.launch {
            val key = loginUseCase(username.trim(), password.trim(), location)
            _loginResult.postValue(key)
        }
    }
}
