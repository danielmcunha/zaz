package com.zaz.app.ui.newAd.adapter

import android.net.Uri
import com.zaz.app.R
import com.zaz.app.databinding.ItemImageAddedBinding
import com.zaz.app.ui.core.base.adapter.RVBaseAdapter
import com.zaz.app.ui.core.base.adapter.RVBaseViewHolder

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