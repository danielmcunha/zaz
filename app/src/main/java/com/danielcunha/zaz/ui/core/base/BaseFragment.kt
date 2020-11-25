package com.danielcunha.zaz.ui.core.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.danielcunha.zaz.BR
import com.danielcunha.zaz.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.SupervisorJob
import org.koin.core.KoinComponent
import kotlin.coroutines.CoroutineContext

abstract class BaseFragment<T : BaseViewModel, V : ViewDataBinding> :
    Fragment(),
    KoinComponent,
    CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    private val job: Job = SupervisorJob()

    protected abstract val viewModel: T

    @LayoutRes
    protected abstract fun layoutResId(): Int

    protected lateinit var binding: V

    protected val mainNavController by lazy {
        requireActivity().findNavController(R.id.nav_host_main)
    }

    @CallSuper
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, layoutResId(), container, false)

        binding.setVariable(BR.viewModel, viewModel)
        binding.lifecycleOwner = this

        viewModel.navigateTo.observe(
            viewLifecycleOwner,
            {
                findNavController().navigate(it)
            }
        )

        viewModel.back.observe(this, {
            findNavController().popBackStack()
        })

        onAfterCreateView(savedInstanceState)

        return binding.root
    }

    open fun onAfterCreateView(savedInstanceState: Bundle?) {}
}