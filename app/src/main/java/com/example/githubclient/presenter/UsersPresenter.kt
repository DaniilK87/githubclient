package com.example.githubclient.presenter


import com.example.githubclient.model.IGithubUsers
import com.example.githubclient.model.users.GithubUser
import com.example.githubclient.navigation.Screens
import com.example.githubclient.presenter.list.IUserListPresenter
import com.example.githubclient.view.UsersView
import com.example.githubclient.view.list.UserItemView
import io.reactivex.rxjava3.core.Scheduler
import moxy.MvpPresenter
import ru.terrakok.cicerone.Router



class UsersPresenter(val uiScheduler: Scheduler, val users: IGithubUsers, val router: Router): MvpPresenter<UsersView>() {

    class UsersListPresenter: IUserListPresenter {

        var users = mutableListOf<GithubUser>()

        override var itemClickListener: ((UserItemView) -> Unit)? = null

        override fun getCount() = users.size

        override fun bindView(view: UserItemView) {
            val user = users[view.pos]
            user.login?.let { view.setName(it) }
            //user.avatarUrl?.let { view.loadAvatar(it) }
        }
    }

    val usersListPresenter = UsersListPresenter()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.init()
        loadData()

        usersListPresenter.itemClickListener = { itemView ->
            val user = usersListPresenter.users[itemView.pos]
            router.navigateTo(Screens.UserLoginScreen(user))
        }
    }

    fun loadData() {
        users.getUsers()
            ?.observeOn(uiScheduler)
            ?.subscribe({ repos ->
                usersListPresenter.users.clear()
                usersListPresenter.users.addAll(repos)
                viewState.updateList()
            }, {
                println("Error: ${it.message}")
            })
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

}