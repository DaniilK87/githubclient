package com.example.githubclient.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.githubclient.R
import com.example.githubclient.presenter.list.IUserListPresenter
import com.example.githubclient.view.list.UserItemView
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_users.view.*

class UsersRVAdapter(val presenter: IUserListPresenter):
    RecyclerView.Adapter<UsersRVAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_users,
            parent,false ))

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int ) {
        holder.pos = position
        holder.containerView.setOnClickListener {
            presenter.itemClickListener?.invoke(holder)
        }
        presenter.bindView(holder)
    }

    inner class ViewHolder(override val containerView: View):
        RecyclerView.ViewHolder(containerView), LayoutContainer, UserItemView {
        override var pos = - 1

        override fun setName(text: String) = with(containerView) {
            tv_name.text = text
        }


    }
}