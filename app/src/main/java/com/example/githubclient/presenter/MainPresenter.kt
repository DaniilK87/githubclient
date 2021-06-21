package com.example.githubclient.presenter


import com.example.githubclient.App
import com.example.githubclient.navigation.Screens
import com.example.githubclient.view.MainView
import moxy.MvpPresenter

class MainPresenter: MvpPresenter<MainView>() {

    val router = App.instance.router

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.UsersScreen())
    }


    fun backClicked() {
        router.exit()
    }

}
