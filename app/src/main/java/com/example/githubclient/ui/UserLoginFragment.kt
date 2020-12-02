package com.example.githubclient.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubclient.App
import com.example.githubclient.R
import com.example.githubclient.model.users.GithubUser
import com.example.githubclient.presenter.UserLoginPresenter
import com.example.githubclient.view.UserLoginView
import kotlinx.android.synthetic.main.item_users.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserLoginFragment: MvpAppCompatFragment(), UserLoginView, BackButtonListener {
    companion object {
        lateinit var currentUser: GithubUser
        fun newInstanceUser(user: GithubUser): UserLoginFragment{
            currentUser = user
            return UserLoginFragment()
        }
    }

    val presenter: UserLoginPresenter by moxyPresenter {
        UserLoginPresenter(App.instance.router)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.item_users, null)

    override fun init() {
        tv_login.text = currentUser.login
    }

    override fun backPressed() = presenter.backPressed()
}
