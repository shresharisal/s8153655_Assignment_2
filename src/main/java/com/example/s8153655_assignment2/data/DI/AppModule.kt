package com.example.s8153655_assignment2.data.DI

import com.example.s8153655_assignment2.data.remote.ApiService
import com.example.s8153655_assignment2.data.repository.RepositoryImpl
import com.example.s8153655_assignment2.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    companion object { // Wrap provides functions in a companion object
        private const val BASE_URL = "https://nit3213api.onrender.com/"

        @Provides
        @Singleton
        fun provideRetrofit(): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        @Provides
        @Singleton
        fun provideApiService(retrofit: Retrofit): ApiService =
            retrofit.create(ApiService::class.java) // Corrected line
    }

    @Binds
    @Singleton
    abstract fun bindRepository(
        impl: RepositoryImpl
    ): Repository
}
