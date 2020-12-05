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
import androidx.lifecycle.LiveData
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
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.navigateTo.observe(viewLifecycleOwner) {
            findNavController().navigate(it)
        }

        viewModel.navigateToMain.observe(viewLifecycleOwner) {
            mainNavController.navigate(it)
        }

        viewModel.back.observe(this) {
            findNavController().popBackStack()
        }

        viewModel.error.observe(this) {

        }

        setupFragment()
        setupViewModel()

        return binding.root
    }

    open fun setupFragment() {}
    open fun setupViewModel() {}

    fun setFragmentResult(key: String, value: Any) {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(
            key,
            value
        )
    }

    fun <T> getFragmentResult(key: String): LiveData<T>? {
        return findNavController().currentBackStackEntry?.savedStateHandle
            ?.getLiveData(key)
    }

//    protected fun requestCameraPermissions() {
//        if (!CameraPermissionHelper.hasCameraPermission(requireActivity())) {
//            CameraPermissionHelper.requestCameraPermission(requireActivity())
//        }
//    }
//
//    override fun onRequestPermissionsResult(
//        requestCode: Int,
//        permissions: Array<out String>,
//        grantResults: IntArray
//    ) {
//        if (!CameraPermissionHelper.hasCameraPermission(requireActivity())) {
//            if (!CameraPermissionHelper.shouldShowRequestPermissionRationale(requireActivity())) {
//                CameraPermissionHelper.launchPermissionSettings(requireActivity())
//            }
//        }
//    }
}