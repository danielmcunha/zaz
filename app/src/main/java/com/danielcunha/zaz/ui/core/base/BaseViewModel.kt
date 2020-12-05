package com.danielcunha.zaz.ui.core.base

import android.app.Application
import androidx.annotation.StringRes
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MediatorLiveData
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
    val navigateToMain = SingleLiveEvent<NavDirections>()
    val back = SingleLiveEvent<Any>()
    val error = SingleLiveEvent<String>()

    val isLoading = MutableLiveData(false)
    val title = MutableLiveData("")

    // Validation
    private val validationRules: ArrayList<() -> Boolean> by lazy {
        ArrayList()
    }

    private val validationStateMap: LinkedHashMap<MutableLiveData<String>, Boolean> by lazy {
        LinkedHashMap()
    }

    private val validationRulesMap: HashMap<MutableLiveData<String>, (String) -> Boolean> by lazy {
        HashMap()
    }

    val valid: MediatorLiveData<Boolean> by lazy {
        MediatorLiveData<Boolean>().also { mediator ->
            validationStateMap.forEach { validationState ->
                mediator.addSource(validationState.key) { fieldValue ->
                    validationStateMap[validationState.key] =
                        validationRulesMap[validationState.key]?.invoke(fieldValue) ?: false
                    mediator.value =
                        validationStateMap.filter { validField -> !validField.value }.isEmpty()
                }
            }
        }
    }

    protected fun setupValidMediator(vararg validations: Pair<MutableLiveData<String>, (String) -> Boolean>) {
        validations.forEach { validationPair ->
            validationStateMap[validationPair.first] = false
            validationRulesMap[validationPair.first] = validationPair.second
        }

        valid.value = false
    }

    fun addValidationRules(vararg validationRules: () -> Boolean) {
        this.validationRules.addAll(validationRules)
    }

    fun validate(): Boolean {
        return !validationRules.map { rules ->
            rules.invoke()
        }.any { !it }
    }

    // End validation

    fun onBackClick() {
        back.call()
    }

    protected fun getString(@StringRes resId: Int): String {
        return getApplication<Application>().getString(resId)
    }

    protected fun getString(@StringRes resId: Int, vararg formatArgs: Any): String {
        return getApplication<Application>().getString(resId, *formatArgs)
    }
}