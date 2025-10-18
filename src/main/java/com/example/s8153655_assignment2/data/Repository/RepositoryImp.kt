package com.example.s8153655_assignment2.data.repository

import com.example.s8153655_assignment2.data.model.Entity
import com.example.s8153655_assignment2.data.remote.ApiService
import com.example.s8153655_assignment2.domain.repository.Repository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RepositoryImpl @Inject constructor(
    private val api: ApiService
) : Repository {

    override suspend fun login(username: String, password: String, location: String): String? {
        val body = mapOf("username" to username, "password" to password)
        val response = api.login(location, body)
        return if (response.isSuccessful) response.body()?.keypass else null
    }

    override suspend fun getDashboard(keypass: String): List<Entity>? {
        val response = api.getDashboard(keypass)
        return if (response.isSuccessful) response.body()?.entities else null
    }
}
