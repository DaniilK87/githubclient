package com.example.githubclient.view.image

interface IImageLouder<T> {
    fun loadInto(url: String, container: T)
}