package com.example.githubclient.presenter


import com.example.githubclient.model.Model
import com.example.githubclient.view.MainView

class MainPresenter (val view: MainView) {

    val model = Model()

    fun counterClick1(id: Int){
        val nextValue = model.next(0)
        view .setButtonText (0, nextValue.toString())
    }

    fun counterClick2(id: Int) {
        val nextValue = model.next ( 1 )
        view .setButtonText( 1 , nextValue.toString())
    }

    fun counterClick3(id: Int) {
        val nextValue = model.next(2)
        view .setButtonText (2, nextValue.toString())
    }
}

