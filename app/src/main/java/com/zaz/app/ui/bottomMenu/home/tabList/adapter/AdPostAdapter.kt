package com.zaz.app.ui.bottomMenu.home.tabList.adapter

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.Drawable
import android.widget.Button
import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.google.firebase.storage.StorageReference
import com.zaz.app.BR
import com.zaz.app.R
import com.zaz.app.ui.core.base.adapter.RVBaseAdapter
import com.zaz.app.ui.core.base.adapter.RVBaseViewHolder


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

        holder.itemView.findViewById<Button>(R.id.btn_details).setOnClickListener {
            clickEvent.invoke(model)
        }
    }
}

data class AdPost(
    val id: Long,
    val title: String,
    val price: String,
    val imageRef: StorageReference,
    val profileImageRef: StorageReference,
    val userName: String,
    val postTime: String
): BaseObservable() {

    @get:Bindable
    var imageBitmap : Bitmap? = null
    set(value) {
        field = value
        notifyPropertyChanged(BR.imageBitmap)
    }

    @get:Bindable
    var profileImageBitmap : Bitmap? = null
        set(value) {
            field = value
            notifyPropertyChanged(BR.profileImageBitmap)
        }

    init {
        imageRef.getBytes(10000 * 10000).addOnSuccessListener {
            imageBitmap = BitmapFactory.decodeByteArray(it, 0, it.size)
        }.addOnFailureListener {

        }

        profileImageRef.getBytes(10000 * 10000).addOnSuccessListener {
            profileImageBitmap = BitmapFactory.decodeByteArray(it, 0, it.size)
        }.addOnFailureListener {

        }
    }
}