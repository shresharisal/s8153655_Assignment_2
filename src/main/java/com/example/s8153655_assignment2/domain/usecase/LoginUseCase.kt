package com.example.s8153655assignment2.domain.usecase


import com.example.s8153655_assignment2.domain.repository.Repository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repo: Repository) {
    suspend operator fun invoke(username: String, password: String, location: String): String? {
        return repo.login(username, password, location)
    }
}
