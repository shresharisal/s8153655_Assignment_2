package com.example.s8153655_assignment2.data.remote

package com.example.app.data.remote

import com.example.s8153655_assignment2.data.model.DashboardResponse
import com.example.s8153655_assignment2.data.model.LoginResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    @POST("{https://nit3213api.onrender.com/sydney/auth")
    suspend fun login(
        @Path("location") location: String,
        @Body body: Map<String, String>
    ): Response<LoginResponse>

    @GET("dashboard/{keypass}")
    suspend fun getDashboard(
        @Path("keypass") keypass: String
    ): Response<DashboardResponse>
}
