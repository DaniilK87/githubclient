package com.example.githubclient.presenter

import android.annotation.SuppressLint
import com.example.githubclient.model.users.GithubUser
import com.example.githubclient.model.users.GithubUsersRepo
import com.example.githubclient.navigation.Screens
import com.example.githubclient.view.UserItemView
import com.example.githubclient.view.UsersView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router

class UsersPresenter (val repo: GithubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>() {


    class UsersListPresenter : IUserListPresenter {

        val users = mutableListOf<GithubUser>()


        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            view.setLogin(user.login)
        }
    }

    val usersListPresenter = UsersListPresenter()
    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()
        usersListPresenter.itemClickListener = { itemView ->
            router.navigateTo(Screens.UserLoginScreen(usersListPresenter.users[itemView.pos]))
        }
    }

    @SuppressLint("CheckResult")
    fun loadData() {
        repo.getUsers().subscribe{ repos ->
          usersListPresenter.users.addAll(listOf(repos))
            viewState.updateList()
        }
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}