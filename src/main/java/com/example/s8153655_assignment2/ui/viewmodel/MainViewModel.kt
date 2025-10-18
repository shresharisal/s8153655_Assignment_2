package com.example.s8153655_assignment2.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s8153655_assignment2.data.model.Entity
import com.example.s8153655_assignment2.domain.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repository: Repository
) : ViewModel() {

    val loginResult = MutableLiveData<String?>()
    val dashboardData = MutableLiveData<List<Entity>?>()
    val errorMessage = MutableLiveData<String?>()

    fun loginUser(username: String, password: String, location: String) {
        viewModelScope.launch {
            try {
                val keypass = repository.login(username, password, location)
                loginResult.value = keypass
                if (keypass == null) errorMessage.value = "Login failed"
            } catch (e: Exception) {
                errorMessage.value = "Error: ${e.localizedMessage}"
            }
        }
    }

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            try {
                dashboardData.value = repository.getDashboard(keypass)
            } catch (e: Exception) {
                errorMessage.value = "Error fetching dashboard: ${e.localizedMessage}"
            }
        }
    }
}
