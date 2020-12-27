package com.danielcunha.zaz.ui.bottomMenu.home.tabList

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.danielcunha.zaz.R
import com.danielcunha.zaz.data.remote.requests.AllBusinessRequest
import com.danielcunha.zaz.domain.usecases.GetAllBusinessUseCase
import com.danielcunha.zaz.ui.bottomMenu.BottomMenuFragmentDirections
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.AdPost
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.AdPostAdapter
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.Category
import com.danielcunha.zaz.ui.bottomMenu.home.tabList.adapter.CategoryAdapter
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.inject

class AdListViewModel(app: Application) : BaseViewModel(app), SwipeRefreshLayout.OnRefreshListener {

    val getAllBusinessUseCase: GetAllBusinessUseCase by inject()
    val categoryAdapter = CategoryAdapter().apply {
        onItemClick = {

        }
    }

    val postAdapter = AdPostAdapter().apply {
        onItemClick = {
            navigateToMain.value =
                BottomMenuFragmentDirections.actionBottomMenuFragmentToAdPostDetail(it.id)
        }
    }

    init {
//        postAdapter.addItem(
//            AdPost(
//                "Desenvolvedor de Sites",
//                "R$ 1500,00",
//                ContextCompat.getDrawable(app, R.drawable.ad_post_sample),
//                ContextCompat.getDrawable(app, R.drawable.image_profile_example),
//                "Floyd Miles",
//                "3 horas atrás"
//            )
//        )

        categoryAdapter.addItem(
            Category(0, R.drawable.ic_building)
        )

        categoryAdapter.addItem(
            Category(0, R.drawable.ic_car)
        )
    }

    fun load() {
        isLoading.value = true
        viewModelScope.launch {
            getAllBusinessUseCase(AllBusinessRequest(POSTS_LIMIT, 0)).fold(
                success = { businessList ->
                    postAdapter.addItems(
                        businessList.map { business ->
                            AdPost(
                                business.id,
                                business.title,
                                business.value,
                                getDrawable(R.drawable.ad_post_sample),
                                getDrawable(R.drawable.image_profile_example),
                                business.name,
                                business.date
                            )
                        }
                    )
                },
                failure = { t ->
                    errorMessage.value = t.message
                }
            ).run {
                isLoading.value = false
            }
        }
    }

    companion object {
        private const val POSTS_LIMIT = 10
    }

    override fun onRefresh() {
        postAdapter.clear()
        load()
    }
}