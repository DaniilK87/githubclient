package com.example.githubclient.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.githubclient.R
import com.example.githubclient.presenter.RepoPresenter
import com.example.githubclient.ui.BackButtonListener
import com.example.githubclient.view.RepoView
import kotlinx.android.synthetic.main.fragment_repo.*
import moxy.MvpAppCompatFragment

class RepoFragment(val presenter: RepoPresenter): MvpAppCompatFragment(), RepoView, BackButtonListener {

    override fun setId(text: String) {
        tv_id.text = text
    }

    override fun setTitle(text: String) {
        tv_title.text = text
    }

    override fun setForksCount(text: String) {
        tv_forksCount.text = text
    }

    override fun init() {
        TODO("Not yet implemented")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? = View.inflate(context, R.layout.fragment_repo,null)

    override fun backPressed() = presenter.backPressed()

}