package com.example.githubclient.model


import io.reactivex.rxjava3.schedulers.Schedulers

class RetrofitGithubUsers(val api: IDataSource): IGithubUsers {

    override fun getUsers() = api.loadUsers().subscribeOn(Schedulers.io())
    
}