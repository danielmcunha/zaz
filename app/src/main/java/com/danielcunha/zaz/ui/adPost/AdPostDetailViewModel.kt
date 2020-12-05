package com.danielcunha.zaz.ui.adPost

import android.app.Application
import com.danielcunha.zaz.ui.core.base.BaseViewModel

class AdPostDetailViewModel(app: Application) : BaseViewModel(app) {

    init {
        title.value = "Desenvolvimento de Sites"
    }
}