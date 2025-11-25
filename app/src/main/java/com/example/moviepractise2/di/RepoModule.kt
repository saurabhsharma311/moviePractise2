package com.example.moviepractise2.di

import com.example.moviepractise2.data.MovieRepoImpal
import com.example.moviepractise2.domain.MovieRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {


    @Binds
    @Singleton
    abstract fun bindRepo(repo: MovieRepoImpal): MovieRepo

}