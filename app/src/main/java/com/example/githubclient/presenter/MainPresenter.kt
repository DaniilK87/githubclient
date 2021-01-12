package com.example.githubclient.presenter


import com.example.githubclient.navigation.Screens
import com.example.githubclient.view.MainView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class MainPresenter(val router: Router): MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        router.replaceScreen(Screens.UsersScreen ())
    }

    fun backClicked() {
        router.exit()
    }

}
