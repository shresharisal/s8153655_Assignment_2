package com.example.s8153655_assignment2.data.DI

import com.example.s8153655_assignment2.configuration.AppConfig
import com.example.s8153655_assignment2.data.Repository.MockAuthRepository
import com.example.s8153655_assignment2.data.remote.ApiService
import com.example.s8153655_assignment2.data.repository.RepositoryImpl
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Qualifier
import javax.inject.Singleton

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class RealApi

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class MockApi

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = AppConfig.API_BASE_URL

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }

        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(AppConfig.CONNECT_TIMEOUT_SECONDS, java.util.concurrent.TimeUnit.SECONDS)
            .readTimeout(AppConfig.READ_TIMEOUT_SECONDS, java.util.concurrent.TimeUnit.SECONDS)
            .writeTimeout(AppConfig.WRITE_TIMEOUT_SECONDS, java.util.concurrent.TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    @RealApi
    fun provideRealAuthRepository(apiService: ApiService): RepositoryImpl {
        return RepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    @MockApi
    fun provideMockAuthRepository(): MockAuthRepository {
        return MockAuthRepository()
    }
