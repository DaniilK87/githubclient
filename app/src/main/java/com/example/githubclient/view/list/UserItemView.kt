package com.example.githubclient.view.list

import com.example.githubclient.view.IItemView

interface UserItemView: IItemView {
    fun setName(text: String)
}