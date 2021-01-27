package com.example.githubclient.model.users

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class GithubUser(
    val login: String
) : Parcelable



