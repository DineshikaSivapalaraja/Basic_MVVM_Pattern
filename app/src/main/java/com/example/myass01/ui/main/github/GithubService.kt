package com.example.myass01.ui.main.github

//import retrofit2.Response
//import retrofit2.http.GET
//
//data class GithubUser(var login: String, var avatar_url: String)
//
//interface GithubService {
//    //@GET("users/{user}/repos")
//    //fun listRepos(@Path("user")user:String?): Call<List<Repo?>?>?
//
//    @GET("users")
//    suspend fun users():Response<List<GithubService>>
//}

import retrofit2.Response
import retrofit2.http.GET

data class GithubUser(var login: String, var avatar_url: String)

interface GithubService {
    @GET("users")
    suspend fun users(): Response<List<GithubUser>>
}