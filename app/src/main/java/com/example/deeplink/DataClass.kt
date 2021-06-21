package com.example.deeplink


import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DataClass(
    val siteUrl: String
) : Parcelable