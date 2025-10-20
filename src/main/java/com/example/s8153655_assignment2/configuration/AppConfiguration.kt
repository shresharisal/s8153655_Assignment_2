package com.example.s8153655_assignment2.configuration

object AppConfig {
    // Set to true to use mock data, false to use real API
    const val USE_MOCK_API = true

    // API Configuration
    const val API_BASE_URL = "https://nit3213api.onrender.com/"
    const val CONNECT_TIMEOUT_SECONDS = 30L
    const val READ_TIMEOUT_SECONDS = 30L
    const val WRITE_TIMEOUT_SECONDS = 30L
}

