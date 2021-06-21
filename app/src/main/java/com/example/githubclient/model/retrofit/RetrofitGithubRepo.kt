package com.example.githubclient.model.retrofit


import com.example.githubclient.model.IDataSource
import com.example.githubclient.model.IGithubRepo
import com.example.githubclient.model.entity.GithubRepo
import com.example.githubclient.model.users.GithubUser
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubRepo (val api: IDataSource): IGithubRepo {
    override fun getRepo(user: GithubUser): Single<List<GithubRepo>>? {
        val url = user.reposUrl
        return url?.let { api.loadRepo(it).subscribeOn(Schedulers.io()) }
    }
}

