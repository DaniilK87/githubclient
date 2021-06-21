package com.example.githubclient.navigation

import androidx.fragment.app.Fragment
import com.example.githubclient.model.users.GithubUser
import com.example.githubclient.ui.UserFragment
import com.example.githubclient.ui.UsersFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {

    class UsersScreen(): SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }

    class UserLoginScreen(val user: GithubUser): SupportAppScreen() {
        override fun getFragment() = UserFragment.newInstance(user)
    }

    class UserRepoScreen():SupportAppScreen() {
        override fun getFragment(): Fragment? {
            return super.getFragment()
        }
    }




}




