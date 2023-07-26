package com.example.myass01.di

import com.example.myass01.ui.main.github.GithubService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module  //define module
//@InstallIn(ActivityComponent::class)  //define where dependency injection is going to reside
@InstallIn(SingletonComponent::class)
object AppModule {

//class AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit = Retrofit.Builder()  //define providers
        .baseUrl("https://api.github.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    @Provides
    fun provideGithubService(retrofit: Retrofit): GithubService =     //define github service
        retrofit.create(GithubService::class.java)


}
