package com.ole.black.list_fc_anko.Model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(val name: String?, val image: Int, val detail: String):Parcelable