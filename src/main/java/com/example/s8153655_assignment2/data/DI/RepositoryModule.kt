package com.example.s8153655_assignment2.di

import com.example.s8153655_assignment2.data.repository.RepositoryImpl
import com.example.s8153655_assignment2.domain.repository.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindRepository(
        impl: RepositoryImpl
    ): Repository
}
