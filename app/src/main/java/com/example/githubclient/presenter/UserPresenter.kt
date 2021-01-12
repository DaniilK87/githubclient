package com.example.githubclient.presenter

import android.content.Context
import android.widget.Toast
import com.example.githubclient.model.users.GithubUser
import com.example.githubclient.model.users.GithubUsersRepo
import com.example.githubclient.navigation.Screens
import com.example.githubclient.view.UserItemView
import com.example.githubclient.view.UsersView
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router
import ru.terrakok.cicerone.Screen
import rx.Observer

class UsersPresenter (val repo: GithubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>(), IUserListPresenter {

    val userObserver = object : Observer<GithubUser> {

        override fun onCompleted() {
            println("onCompleted")
        }

        override fun onError(e: Throwable?) {
            println("onError: $e")
        }

        override fun onNext(t: GithubUser?) {
            println("onNext: $t")
        }
    }

    fun getUser() {
        repo.getUsers().subscribe(userObserver)
    }

    var users = mutableListOf<GithubUser>()

    override var itemClickListener: ((UserItemView) -> Unit)? = null


    override fun bindView(view: UserItemView) {
        val user = users[view.pos]
        view.setLogin(user.login)
    }

    override fun getCount() = users.size
}




    /*class UsersListPresenter(val usersPresenter: UsersPresenter) : IUserListPresenter {

        var users = mutableListOf<GithubUser>()


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

    fun loadData() {
        //val users = getUser()
        usersListPresenter.users.getUser()
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}*/