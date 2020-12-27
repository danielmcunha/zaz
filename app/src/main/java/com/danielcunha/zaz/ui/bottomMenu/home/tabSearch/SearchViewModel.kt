package com.danielcunha.zaz.ui.bottomMenu.home.tabSearch

import android.app.Application
import androidx.core.content.ContextCompat
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.bottomMenu.home.tabSearch.adapter.SearchCategory
import com.danielcunha.zaz.ui.bottomMenu.home.tabSearch.adapter.SearchCategoryAdapter
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class SearchViewModel(app: Application) : BaseViewModel(app) {

    val searchText = MutableLiveData<String>()
    val adapter = SearchCategoryAdapter()

    init {
        adapter.setup(listOf(
            SearchCategory(
                0,
                "Serviços",
                R.drawable.ic_gear_white,
                R.drawable.ic_gear
            ),
            SearchCategory(
                1,
                "Alimentação",
                R.drawable.ic_restaurant_white,
                R.drawable.ic_restaurant
            )
        ))
    }
}