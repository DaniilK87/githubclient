package com.example.githubclient.presenter

import com.example.githubclient.view.IItemView
import com.example.githubclient.view.UserItemView

interface IListPresenter <V: IItemView> {
    var itemClickListener: ((V) -> Unit) ?
    fun bindView(view: V)
    fun getCount(): Int
}
interface IUserListPresenter: IListPresenter<UserItemView>