package com.example.s8153655assignment2.presentation.dashboard

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.s8153655_assignment2.data.model.Entity
import com.example.s8153655assignment2.domain.usecase.GetDashboardUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val getDashboardUseCase: GetDashboardUseCase
) : ViewModel() {
    val entities = MutableLiveData<List<Entity>>()

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            val list = getDashboardUseCase(keypass)
            entities.postValue(list ?: emptyList())
        }
    }
}
