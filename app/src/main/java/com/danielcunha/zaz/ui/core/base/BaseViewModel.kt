package com.danielcunha.zaz.ui.core.base

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.navigation.NavDirections
import com.danielcunha.zaz.ui.core.base.singleLiveEvent.SingleLiveEvent
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

open class BaseViewModel(open val app: Application) :
    AndroidViewModel(app),
    KoinComponent,
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job: Job = SupervisorJob()

    val navigateTo = SingleLiveEvent<NavDirections>()
    val back = SingleLiveEvent<Any>()

    val isLoading = MutableLiveData(false)

    //endregion

    protected fun getString(@StringRes resId: Int): String {
        return getApplication<Application>().getString(resId)
    }

    protected fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
        return getApplication<Application>().getString(resId, *formatArgs)
    }
}