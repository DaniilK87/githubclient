package com.example.githubclient.presenter

import com.example.githubclient.model.IGithubRepo
import com.example.githubclient.model.entity.GithubRepo
import com.example.githubclient.model.users.GithubUser
import com.example.githubclient.navigation.Screens
import com.example.githubclient.presenter.list.IRepoListPresenter
import com.example.githubclient.presenter.list.IUserListPresenter
import com.example.githubclient.view.UserView
import com.example.githubclient.view.list.RepoItemView
import com.example.githubclient.view.list.UserItemView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UserPresenter (val repo: IGithubRepo,val user: GithubUser, val uiScheduler: Scheduler, val router: Router): MvpPresenter<UserView>() {

    class RepoListPresenter: IRepoListPresenter{
        val  repo = mutableListOf<GithubRepo>()
        override var itemClickListener: ((RepoItemView) -> Unit)? = null


        override fun bindView(view: RepoItemView) {
            val repos = repo[view.pos]
            repos.name?.let { view.setLogin(it) }
        }

        override fun getCount()= repo.size
    }

    val repoListPresenter = RepoListPresenter()


    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        repoListPresenter.itemClickListener = {repoItemView ->
            val repos = repoListPresenter.repo[repoItemView.pos]
        }
    }


    fun loadData() {
            repo.getRepo(user)?.observeOn(uiScheduler)?.subscribe({ repo ->
                repoListPresenter.repo.clear()
                repoListPresenter.repo.addAll(repo)
                viewState.updateList()
            }, {e -> println("Error: $e")})
        }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}