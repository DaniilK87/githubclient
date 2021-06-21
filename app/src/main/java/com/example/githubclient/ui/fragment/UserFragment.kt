package com.example.githubclient.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubclient.ApiHolder
import com.example.githubclient.App
import com.example.githubclient.R
import com.example.githubclient.model.entity.GithubRepo
import com.example.githubclient.model.retrofit.RetrofitGithubRepo
import com.example.githubclient.model.users.GithubUser
import com.example.githubclient.presenter.UserPresenter
import com.example.githubclient.view.UserView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import kotlinx.android.synthetic.main.fragment_user.*
import moxy.MvpAppCompatFragment
import moxy.ktx.moxyPresenter

class UserFragment: MvpAppCompatFragment(), UserView, BackButtonListener {


    companion object {
        private const val USER_ARG = "user"

        fun newInstance(user: GithubUser) = UserFragment().apply {
            arguments = Bundle().apply { putParcelable(USER_ARG, user) }
        }

    }

    val presenter: UserPresenter by moxyPresenter {
        val user = arguments?.getParcelable<GithubUser>(USER_ARG) as GithubUser
        UserPresenter (RetrofitGithubRepo(ApiHolder.api),user, AndroidSchedulers.mainThread(), App.instance.router)
    }
    var adapter: UserRVAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = View.inflate(context, R.layout.fragment_user, null)

    override fun init() {
        rv_user.layoutManager = LinearLayoutManager(context)
        adapter = UserRVAdapter(presenter.repoListPresenter)
        rv_user.adapter = adapter
    }

    override fun updateList() {
        adapter?.notifyDataSetChanged()
    }

    override fun backPressed() = presenter.backPressed()
}
