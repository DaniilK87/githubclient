package com.example.githubclient.view.list

import com.example.githubclient.view.IItemView

interface RepoItemView: IItemView {
    fun setLogin(text: String)
}