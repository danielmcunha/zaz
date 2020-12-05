package com.danielcunha.zaz.ui.adPost

import android.app.Application
import androidx.core.content.ContextCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.danielcunha.zaz.R
import com.danielcunha.zaz.ui.adPost.adapter.AdPostRating
import com.danielcunha.zaz.ui.adPost.adapter.AdPostRatingAdapter
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class AdPostDetailViewModel(app: Application) : BaseViewModel(app) {

    val ratingAdapter = AdPostRatingAdapter()

    private val _adType = MutableLiveData<String>()
    val adType : LiveData<String> = _adType

    private val _adDate = MutableLiveData<String>()
    val adDate : LiveData<String> = _adDate

    private val _adImage = MutableLiveData<Int>()
    val adImage : LiveData<Int> = _adImage

    private val _adPrice = MutableLiveData<String>()
    val adPrice : LiveData<String> = _adPrice

    private val _adDescription = MutableLiveData<String>()
    val adDescription : LiveData<String> = _adDescription

    private val _userName = MutableLiveData<String>()
    val userName : LiveData<String> = _userName

    private val _adRatingStars = MutableLiveData<String>()
    val adRatingStars : LiveData<String> = _adRatingStars

    init {
        title.value = "Desenvolvimento de Sites"
        _adType.value = "Serviços"
        _adDate.value = "Hoje"
        _adImage.value = R.drawable.ad_post_sample
        _adPrice.value = "R$ 750,00"
        _adDescription.value = "Programa, codifica e testa sistemas. Executa a manutenção dos sistemas, fazendo eventuais correções necessárias, visando atender às necessidades dos usuários. Desenvolve trabalhos de montagem, depuração e testes de programas, executando serviços de manutenção nos programas já desenvolvidos."
        _userName.value = "Floyd Miles"
        _adRatingStars.value = "4,5"
        ratingAdapter.addItem(
            AdPostRating(
                "Meryl Streep",
                ContextCompat.getDrawable(app, R.drawable.image_profile_example),
                4.5f,
                "Excelente profissional"
            )
        )
    }

    fun actionShare() {

    }

    fun actionRate() {

    }
}