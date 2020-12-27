package com.danielcunha.zaz.ui.bottomMenu.home.tabSearch.adapter

import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.core.base.adapter.RVBaseAdapter

class SearchCategoryAdapter : RVBaseAdapter<SearchCategory>() {
    override fun getLayoutIdForPosition(position: Int) = R.layout.item_search_category
    var itemSelected: Int = 0

    private val onItemSelected: (Int) -> Unit = { id ->

    }

    fun setup(items: List<SearchCategory>) {
        items[itemSelected].selected.value = true
        items.forEach {
            it.onItemSelected = onItemSelected
        }
        addItems(items)
    }
}

data class SearchCategory(
    val id: Int,
    val text: String,
    val iconSelected: Int,
    val iconUnselected: Int
) {
    val selected = MutableLiveData(false)
    var onItemSelected: ((Int) -> Unit)? = null
}