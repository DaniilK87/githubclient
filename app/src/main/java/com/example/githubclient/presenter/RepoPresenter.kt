package com.example.githubclient.presenter


import com.example.githubclient.model.entity.GithubRepo
import com.example.githubclient.view.RepoView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class RepoPresenter(val repo: GithubRepo,val router: Router): MvpPresenter<RepoView>() {


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        viewState.setId(repo.id ?: " ")
        viewState.setTitle(repo.name ?: " ")
        viewState.setForksCount((repo.forksCount ?: 0).toString())
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}