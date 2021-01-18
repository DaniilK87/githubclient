package com.example.githubclient.presenter


import com.example.githubclient.model.users.GithubUser
import com.example.githubclient.model.users.GithubUsersRepo
import com.example.githubclient.navigation.Screens
import com.example.githubclient.view.UserItemView
import com.example.githubclient.view.UsersView
import io.reactivex.Observer
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router


class UsersPresenter (val repo: GithubUsersRepo, val router: Router) :
    MvpPresenter<UsersView>() {

    val userObserver = object : Observer<GithubUser> {
        var disposable: Disposable? = null


        override fun onError(e: Throwable) {
            println("onError: $e")
        }

        override fun onNext(t: GithubUser) {
            println("onNext: $t")
        }

        override fun onComplete() {
            println("onCompleted")
        }

        override fun onSubscribe(d: Disposable) {
             disposable = d
            println("onSubscribe")
        }

    }

    fun getUser() {
        repo.getUsers().subscribe(userObserver)
    }



    class UsersListPresenter : IUserListPresenter {

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
        usersListPresenter.users.addAll(getUser())
        viewState.updateList()
    }

    fun backPressed(): Boolean {
        router.exit()
        return true
    }
}