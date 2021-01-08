package com.danielcunha.zaz.ui.newAd.adapter

import android.net.Uri
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.ItemImageAddedBinding
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseAdapter
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseViewHolder

class ImageAddedAdapter : RVBaseAdapter<ImageAdded>() {

    var isEmpty: ((Boolean) -> Unit)? = null

    override fun getLayoutIdForPosition(position: Int) = R.layout.item_image_added

    override fun onBindViewHolder(holder: RVBaseViewHolder<ImageAdded>, position: Int) {
        super.onBindViewHolder(holder, position)

        (holder.binding as ItemImageAddedBinding).ivClose.setOnClickListener {
            notifyItemRemoved(viewModels.indexOf(holder.binding.viewHolder))
            viewModels.removeAt(viewModels.indexOf(holder.binding.viewHolder))
            isEmpty?.invoke(viewModels.isEmpty())
        }
    }
}

data class ImageAdded(
    val uri: Uri
)