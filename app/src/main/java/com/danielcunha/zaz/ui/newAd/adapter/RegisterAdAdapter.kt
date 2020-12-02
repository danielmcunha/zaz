package com.danielcunha.zaz.ui.newAd.adapter

import android.os.Parcelable
import androidx.annotation.DrawableRes
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseAdapter
import com.danielcunha.zaz.ui.core.base.singleLiveEvent.SingleLiveEvent
import kotlinx.android.parcel.Parcelize

class RegisterAdAdapter() : RVBaseAdapter<RegisterAdViewHolder>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_register_ad
}

@Parcelize
data class RegisterAdViewHolder(
    val text: String,
    @DrawableRes val iconRes: Int
) : Parcelable


