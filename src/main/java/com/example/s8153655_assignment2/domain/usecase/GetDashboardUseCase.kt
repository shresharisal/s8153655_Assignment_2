package com.example.s8153655assignment2.domain.usecase

import com.example.s8153655_assignment2.data.model.Entity
import com.example.s8153655_assignment2.domain.repository.Repository


import javax.inject.Inject

class GetDashboardUseCase @Inject constructor(private val repo: Repository.Repository) {
    suspend operator fun invoke(keypass: String): List<Entity>? {
        return repo.getDashboard(keypass)
    }
}
