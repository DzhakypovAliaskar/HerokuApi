package com.example.animebay.di

import com.example.data.repositories.AnimeRepositoryImpl
import com.example.domain.repositories.AnimeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoriesModule {

    @Binds
    abstract fun provideAnimeRepository(repositoryImpl: AnimeRepositoryImpl): AnimeRepository
}