package com.example.githubclient.model

import com.example.githubclient.model.entity.GithubRepo
import com.example.githubclient.model.users.GithubUser
import io.reactivex.rxjava3.annotations.NonNull
import io.reactivex.rxjava3.core.Single

interface IGithubRepo {
    fun getRepo(user: GithubUser): @NonNull Single<List<GithubRepo>>?
}