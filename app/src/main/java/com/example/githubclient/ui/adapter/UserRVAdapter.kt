package com.example.githubclient.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.R
import com.example.githubclient.presenter.list.IRepoListPresenter
import com.example.githubclient.view.list.RepoItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_repository.view.*

class UserRVAdapter(val presenter: IRepoListPresenter):
    RecyclerView.Adapter<UserRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).
    inflate(R.layout.item_repository, parent,false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.pos = position
        holder.containerView.setOnClickListener {
            presenter.itemClickListener?.invoke(holder)
        }
    }

    override fun getItemCount() = presenter.getCount()

    inner class ViewHolder(override val containerView: View): RecyclerView.ViewHolder(containerView), LayoutContainer, RepoItemView{

        override fun setLogin(text: String) = with(containerView) {
            tv_repo.text = text
        }

        override var pos = -1
    }

    }


