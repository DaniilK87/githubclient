package com.example.githubclient.navigation

import androidx.fragment.app.Fragment
import com.example.githubclient.model.users.GithubUser
import com.example.githubclient.ui.UserLoginFragment
import com.example.githubclient.ui.UsersFragment
import kotlinx.android.parcel.Parcelize
import ru.terrakok.cicerone.android.support.SupportAppScreen

class Screens {
    class UsersScreen(): SupportAppScreen() {
        override fun getFragment() = UsersFragment.newInstance()
    }

    class UserLoginScreen(val user: GithubUser): SupportAppScreen() {
        override fun getFragment() = UserLoginFragment.newInstanceUser(user)
        }
    }
