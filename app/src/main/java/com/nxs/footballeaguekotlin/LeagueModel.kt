package com.nxs.footballeaguekotlin

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class LeagueModel(val name: String, val description: String, val image: Int) : Parcelable