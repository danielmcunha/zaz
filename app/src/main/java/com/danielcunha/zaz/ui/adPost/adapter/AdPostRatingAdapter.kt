package com.danielcunha.zaz.ui.adPost.adapter

import android.graphics.drawable.Drawable
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseAdapter

class AdPostRatingAdapter : RVBaseAdapter<AdPostRating>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_ad_post_rating
}

data class AdPostRating(
    val userName: String,
    val userImage: Drawable?,
    val stars: Float,
    val comment: String
)