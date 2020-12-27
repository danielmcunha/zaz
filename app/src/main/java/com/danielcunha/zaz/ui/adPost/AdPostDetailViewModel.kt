package com.danielcunha.zaz.ui.adPost

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.danielcunha.zaz.R
import com.danielcunha.zaz.domain.usecases.GetBusinessUseCase
import com.danielcunha.zaz.ui.adPost.adapter.AdPostRatingAdapter
import com.danielcunha.zaz.ui.core.base.BaseViewModel
import kotlinx.coroutines.launch
import org.koin.core.inject

class AdPostDetailViewModel(app: Application) : BaseViewModel(app) {

    private val getBusinessUseCase: GetBusinessUseCase by inject()
    var businessId: Long? = null

    val ratingAdapter = AdPostRatingAdapter()
    val adType = MutableLiveData<String>()
    val adDate = MutableLiveData<String>()
    val adImage = MutableLiveData(R.drawable.ad_post_sample)
    val adPrice = MutableLiveData<String>()
    val adDescription = MutableLiveData<String>()
    val userName = MutableLiveData<String>()
    val adRatingStars = MutableLiveData<String>()

    init {
//        title.value = "Desenvolvimento de Sites"
//        adType.value = "Serviços"
//        adDate.value = "Hoje"
//        adImage.value = R.drawable.ad_post_sample
//        adPrice.value = "R$ 750,00"
//        adDescription.value = "Programa, codifica e testa sistemas. Executa a manutenção dos sistemas, fazendo eventuais correções necessárias, visando atender às necessidades dos usuários. Desenvolve trabalhos de montagem, depuração e testes de programas, executando serviços de manutenção nos programas já desenvolvidos."
//        userName.value = "Floyd Miles"
//        adRatingStars.value = "4,5"
//        ratingAdapter.addItem(
//            AdPostRating(
//                "Meryl Streep",
//                ContextCompat.getDrawable(app, R.drawable.image_profile_example),
//                4.5f,
//                "Excelente profissional"
//            )
//        )
    }

    fun load() {
        val businessId = businessId ?: return

        viewModelScope.launch {
            getBusinessUseCase(businessId).fold(
                success = {
                    title.value = it.title
                    adType.value = it.categoryName
                    adDate.value = it.date
                    adPrice.value = it.value
                    adDescription.value = it.description
                    userName.value = it.name
                },
                failure = {
                    errorMessage.value = it.message
                }
            )
        }
    }

    fun actionShare() {

    }

    fun actionRate() {
        navigateTo.value = AdPostDetailFragmentDirections.actionAdPostDetailToNewRating(title.value.orEmpty())
    }
}