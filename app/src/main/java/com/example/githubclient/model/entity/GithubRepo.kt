package com.example.githubclient.model.entity

import android.os.Parcelable
import com.google.gson.annotations.Expose
import kotlinx.android.parcel.Parcelize


@Parcelize
data class GithubRepo (
     @Expose val id: String? = null,
     @Expose val name: String? = null,
     @Expose val forksCount: Int? = null
): Parcelable