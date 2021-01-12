package com.example.githubclient.model.users

import rx.Observable
import rx.Observer

class GithubUsersRepo {
    private val repo = listOf(
        GithubUser ( "login1" ),
        GithubUser ( "login2" ) ,
        GithubUser ( "login3" ) ,
        GithubUser ( "login4" ) ,
        GithubUser ( "login5" )
    )


    fun getUsers(): Observable<GithubUser> {
        return Observable.from(repo)
    }




}