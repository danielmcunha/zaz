package com.zaz.app.ui.bottomMenu.home.tabSearch.adapter

import androidx.lifecycle.MutableLiveData
import com.zaz.app.R
import com.zaz.app.ui.core.base.adapter.RVBaseAdapter
import com.zaz.app.ui.core.base.adapter.RVBaseViewHolder

class SearchCategoryAdapter : RVBaseAdapter<SearchCategory>() {
    override fun getLayoutIdForPosition(position: Int) = R.layout.item_search_category
    var itemSelected: Int = 0

    private val onItemSelected: (Int) -> Unit = { id ->

    }

    fun setup(items: List<SearchCategory>) {
        items[itemSelected].selected.value = true
        addItems(items)
    }

    override fun onBindViewHolder(holder: RVBaseViewHolder<SearchCategory>, position: Int) {
        super.onBindViewHolder(holder, position)
        holder.itemView.setOnClickListener {
            viewModels[itemSelected].selected.value = false
            viewModels[position].selected.value = true
            itemSelected = position
        }
    }
}

data class SearchCategory(
    val id: Int,
    val text: String,
    val iconSelected: Int,
    val iconUnselected: Int
) {
    val selected = MutableLiveData(false)
}