package com.example.githubclient.view

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.AddToEndSingle

@StateStrategyType(AddToEndSingleStrategy::class)
interface RepoView: MvpView {
    fun setId(text: String)
    fun setTitle(text: String)
    fun setForksCount(text: String)
    fun init()
}