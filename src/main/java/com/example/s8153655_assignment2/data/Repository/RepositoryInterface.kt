package com.example.s8153655_assignment2.data.Repository

import com.example.s8153655_assignment2.data.model.DashboardResponse
import com.example.s8153655_assignment2.data.model.LoginRequest
import com.example.s8153655_assignment2.data.model.LoginResponse

interface AuthRepositoryInterface {
    suspend fun loginFootscray(loginRequest: LoginRequest): Result<LoginResponse>
    suspend fun loginSydney(loginRequest: LoginRequest): Result<LoginResponse>
    suspend fun loginBr(loginRequest: LoginRequest): Result<LoginResponse>
    suspend fun getDashboard(keypass: String): Result<DashboardResponse>
}
