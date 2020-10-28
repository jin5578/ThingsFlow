package com.tistory.jeongs0222.thingsflow.model.args

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class DetailArgs(
    val org: String,
    val repo: String
): Parcelable