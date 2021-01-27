package com.example.githubclient.model.users

import io.reactivex.Observable



class GithubUsersRepo {

    private val repo = listOf(
        GithubUser ( "login1" ),
        GithubUser ( "login2" ) ,
        GithubUser ( "login3" ) ,
        GithubUser ( "login4" ) ,
        GithubUser ( "login5" )
    )


    fun getUsers(): Observable<GithubUser> {
        return Observable.fromIterable(repo)
    }

}

