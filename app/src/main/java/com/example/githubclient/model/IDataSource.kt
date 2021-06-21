package com.example.githubclient.model

import com.example.githubclient.model.entity.GithubRepo
import com.example.githubclient.model.users.GithubUser
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Url

interface  IDataSource {

    @GET("/users")
    fun loadUsers(): Single<List<GithubUser>>

    @GET
    fun loadRepo(@Url url: String): Single<List<GithubRepo>>

}