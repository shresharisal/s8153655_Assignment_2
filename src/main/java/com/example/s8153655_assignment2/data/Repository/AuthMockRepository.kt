package com.example.s8153655_assignment2.data.Repository

import com.example.s8153655_assignment2.data.model.DashboardResponse
import com.example.s8153655_assignment2.data.model.Entity
import com.example.s8153655_assignment2.data.model.LoginRequest
import com.example.s8153655_assignment2.data.model.LoginResponse
import kotlinx.coroutines.delay
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockAuthRepository @Inject constructor() : AuthRepositoryInterface {

    override suspend fun loginFootscray(loginRequest: LoginRequest): Result<LoginResponse> {
        return try {
            // Simulate network delay
            delay(1000)

            // Validate credentials (basic validation)
            if (loginRequest.username.isBlank() || loginRequest.password.isBlank()) {
                return Result.failure(Exception("Username and password cannot be empty"))
            }

            // Mock successful login
            val response = LoginResponse("mock-keypass-footscray")
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun loginSydney(loginRequest: LoginRequest): Result<LoginResponse> {
        return try {
            delay(1000)

            if (loginRequest.username.isBlank() || loginRequest.password.isBlank()) {
                return Result.failure(Exception("Username and password cannot be empty"))
            }

            val response = LoginResponse("mock-keypass-sydney")
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun loginBr(loginRequest: LoginRequest): Result<LoginResponse> {
        return try {
            delay(1000)

            if (loginRequest.username.isBlank() || loginRequest.password.isBlank()) {
                return Result.failure(Exception("Username and password cannot be empty"))
            }

            val response = LoginResponse("mock-keypass-br")
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getDashboard(keypass: String): Result<DashboardResponse> {
        return try {
            delay(1000)

            // Mock dashboard data
            val entities = listOf(
                Entity(
                    property1 = "Sample Property 1",
                    property2 = "Sample Value 1",
                    description = "This is a detailed description for the first entity. It contains comprehensive information about the entity's properties and characteristics."
                ),
                Entity(
                    property1 = "Sample Property 2",
                    property2 = "Sample Value 2",
                    description = "This is a detailed description for the second entity. It provides additional context and information about the entity's features."
                ),
                Entity(
                    property1 = "Sample Property 3",
                    property2 = "Sample Value 3",
                    description = "This is a detailed description for the third entity. It includes specific details about the entity's attributes and behavior."
                ),
                Entity(
                    property1 = "Sample Property 4",
                    property2 = "Sample Value 4",
                    description = "This is a detailed description for the fourth entity. It offers insights into the entity's functionality and purpose."
                ),
                Entity(
                    property1 = "Sample Property 5",
                    property2 = "Sample Value 5",
                    description = "This is a detailed description for the fifth entity. It explains the entity's role and significance in the system."
                )
            )

            val response = DashboardResponse(entities, entities.size)
            Result.success(response)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
