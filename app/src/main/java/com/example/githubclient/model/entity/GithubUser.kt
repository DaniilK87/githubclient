package com.example.githubclient.model.users

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize
import retrofit2.http.Url

@Parcelize
data class GithubUser(
    @Expose val id: String,
    @Expose val login: String,
    @Expose val avatarUrl: String? = null,
    @Expose val reposUrl: String? = null
): Parcelable