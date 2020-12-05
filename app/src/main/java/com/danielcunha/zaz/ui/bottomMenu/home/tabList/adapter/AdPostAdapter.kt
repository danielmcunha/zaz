package com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseAdapter
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseViewHolder

class AdPostAdapter : RVBaseAdapter<AdPost>() {

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_ad_post

    override fun handleItemClick(
        holder: RVBaseViewHolder<AdPost>,
        model: AdPost,
        clickEvent: (AdPost) -> Unit
    ) {
        holder.itemView.findViewById<ImageView>(R.id.iv_ad).setOnClickListener {
            clickEvent.invoke(model)
        }
    }
}

data class AdPost(
    val title: String,
    val price: String,
    val postImage: Drawable?,
    val userImage: Drawable?,
    val userName: String,
    val postTime: String
)