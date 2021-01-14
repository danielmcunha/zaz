package com.zaz.app.ui.bottomMenu.home.tabList

import android.app.Application
import androidx.lifecycle.viewModelScope
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.zaz.app.R
import com.zaz.app.data.remote.requests.AllBusinessRequest
import com.zaz.app.domain.models.AuthUser
import com.zaz.app.domain.usecases.GetAllBusinessUseCase
import com.zaz.app.domain.usecases.GetCategoriesUseCase
import com.zaz.app.ui.bottomMenu.BottomMenuFragmentDirections
import com.zaz.app.ui.bottomMenu.home.tabList.adapter.AdPost
import com.zaz.app.ui.bottomMenu.home.tabList.adapter.AdPostAdapter
import com.zaz.app.ui.bottomMenu.home.tabList.adapter.CategoryViewHolder
import com.zaz.app.ui.bottomMenu.home.tabList.adapter.CategoryAdapter
import com.zaz.app.ui.core.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.inject

class AdListViewModel(app: Application) : BaseViewModel(app), SwipeRefreshLayout.OnRefreshListener {

    val getAllBusinessUseCase: GetAllBusinessUseCase by inject()
    val getCategoriesUseCase: GetCategoriesUseCase by inject()
    private val firebaseStorage = Firebase.storage.reference
    private val authUser: AuthUser by inject()

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
        categoryAdapter.addItems(
            listOf(
                CategoryViewHolder(0, R.drawable.ic_building),
                CategoryViewHolder(1, R.drawable.ic_car),
                CategoryViewHolder(2, R.drawable.ic_sale),
                CategoryViewHolder(3, R.drawable.ic_ecommerce),
                CategoryViewHolder(4, R.drawable.ic_handshake),
            )
        )
    }

    fun load() {
        isLoading.value = true
        viewModelScope.launch {
            getAllBusinessUseCase(AllBusinessRequest(POSTS_LIMIT, 0)).fold(
                success = { businessList ->
                    postAdapter.addItems(
                        businessList.map { business ->
                            val imageRef = firebaseStorage.child("${business.id}/0.jpg")
                            val profileRef = firebaseStorage.child("${authUser.user.email}/profile.jpg")

                            AdPost(
                                business.id,
                                business.title,
                                business.value,
                                imageRef,
                                profileRef,
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

        viewModelScope.launch {
            getCategoriesUseCase(null).fold(
                success = {
                    
                },
                failure = {
                    errorMessage.value = it.message
                }
            )
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