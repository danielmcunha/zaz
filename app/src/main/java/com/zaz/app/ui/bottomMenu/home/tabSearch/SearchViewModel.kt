package com.zaz.app.ui.bottomMenu.home.tabSearch

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.zaz.app.R
import com.zaz.app.ui.bottomMenu.home.tabSearch.adapter.SearchCategory
import com.zaz.app.ui.bottomMenu.home.tabSearch.adapter.SearchCategoryAdapter
import com.zaz.app.ui.core.base.BaseViewModel

class SearchViewModel(app: Application) : BaseViewModel(app) {

    val searchText = MutableLiveData<String>()
    val adapter = SearchCategoryAdapter()

    init {
        adapter.setup(listOf(
            SearchCategory(
                0,
                getString(R.string.services),
                R.drawable.ic_gear_white,
                R.drawable.ic_gear
            ),
            SearchCategory(
                1,
                getString(R.string.food),
                R.drawable.ic_restaurant_white,
                R.drawable.ic_restaurant
            ),
            SearchCategory(
                2,
                getString(R.string.properties),
                R.drawable.ic_home_white,
                R.drawable.ic_home_orange
            ),
            SearchCategory(
                3,
                getString(R.string.properties),
                R.drawable.ic_sale_white,
                R.drawable.ic_sale
            )
        ))
    }
}