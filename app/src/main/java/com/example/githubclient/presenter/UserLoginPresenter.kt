package com.example.githubclient.presenter

import com.example.githubclient.view.UserLoginView
import com.example.githubclient.view.UsersView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UserLoginPresenter(val router: Router) : MvpPresenter<UserLoginView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
    }

    fun backPressed():Boolean {
        router.exit()
        return true
    }
}