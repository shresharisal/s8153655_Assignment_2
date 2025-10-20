package com.example.s8153655_assignment2.data.remote

import com.example.s8153655_assignment2.data.model.LoginRequest
import com.example.s8153655_assignment2.data.model.DashboardResponse
import com.example.s8153655_assignment2.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path


interface MockApiService {

    @POST("footscray/auth")
    suspend fun loginFootscray(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("sydney/auth")
    suspend fun loginSydney(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @POST("br/auth")
    suspend fun loginBr(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(@Path("keypass") keypass: String): Response<DashboardResponse>
}

