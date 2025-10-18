package com.example.s8153655_assignment2.domain.repository
import com.example.s8153655_assignment2.data.model.Entity
open class Repository {interface Repository {
    suspend fun login(username: String, password: String, location: String): String?
    suspend fun getDashboard(keypass: String): List<Entity>?
}
}