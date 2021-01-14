package com.zaz.app.ui.newAd.adapter

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.zaz.app.R
import com.zaz.app.ui.core.base.adapter.RVBaseAdapter
import kotlinx.android.parcel.Parcelize

class RegisterAdAdapter() : RVBaseAdapter<RegisterAdViewHolder>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_register_ad
}

@Parcelize
data class RegisterAdViewHolder(
    val text: String,
    @DrawableRes val iconRes: Int
) : Parcelable


