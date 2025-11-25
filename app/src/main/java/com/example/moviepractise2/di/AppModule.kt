package com.example.moviepractise2.di

import com.example.moviepractise2.data.MovieRepoImpal
import com.example.moviepractise2.data.remote.model.SearchMovieApi
import com.example.moviepractise2.domain.MovieRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit{
        return Retrofit.Builder().baseUrl("https://www.omdbapi.com/").addConverterFactory(
            GsonConverterFactory.create()).build()
    }

    @Provides
    fun provideMovieApi() : SearchMovieApi {
        return provideRetrofit().create(SearchMovieApi::class.java)
    }


}