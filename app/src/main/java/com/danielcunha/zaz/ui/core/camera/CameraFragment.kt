package com.danielcunha.zaz.ui.core.camera

import android.net.Uri
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.ImageCaptureException
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.FragmentCameraBinding
import com.danielcunha.zaz.ui.core.base.BaseFragment
import java.io.File
import java.text.SimpleDateFormat
import java.util.*

class CameraFragment : BaseFragment<CameraViewModel, FragmentCameraBinding>() {

    override val viewModel: CameraViewModel by viewModels()
    override fun layoutResId() = R.layout.fragment_camera

    lateinit var imageCapture: ImageCapture

    private val outputDirectory by lazy {
        val mediaDir = requireContext().externalMediaDirs.firstOrNull()?.let {
            File(it, resources.getString(R.string.app_name)).apply { mkdirs() }
        }

        if (mediaDir != null && mediaDir.exists()) {
            mediaDir
        } else {
            requireContext().filesDir
        }
    }

    override fun setupFragment() {
        startCamera()
    }

    override fun setupViewModel() {
        viewModel.takePhoto.observe(this) {
            takePhoto()
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(requireContext())

        cameraProviderFuture.addListener({
            val cameraProvider: ProcessCameraProvider = cameraProviderFuture.get()

            val preview = Preview.Builder()
                .build()
                .also {
                    it.setSurfaceProvider(binding.pvCamera.surfaceProvider)
                }

            imageCapture = ImageCapture.Builder().build()

            val cameraSelector = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()
                cameraProvider.bindToLifecycle(viewLifecycleOwner, cameraSelector, preview, imageCapture)
            } catch (exc: Exception) {

            }
        }, ContextCompat.getMainExecutor(requireContext()))
    }

    private fun takePhoto() {

        val photoFile = File(
            outputDirectory,
            SimpleDateFormat(FILENAME_FORMAT, Locale.US).format(System.currentTimeMillis()) + ".jpg"
        )

        val outputOptions = ImageCapture.OutputFileOptions.Builder(photoFile).build()

        imageCapture.takePicture(
            outputOptions,
            ContextCompat.getMainExecutor(requireContext()),
            object : ImageCapture.OnImageSavedCallback {
                override fun onError(exc: ImageCaptureException) {
                    setFragmentResult(CAMERA_ERROR_RESULT, exc.message.orEmpty())
                    close()
                }

                override fun onImageSaved(output: ImageCapture.OutputFileResults) {
                    val savedUri = Uri.fromFile(photoFile)

                    setFragmentResult(CAMERA_SUCCESS_RESULT, savedUri)
                    close()
                }
            })
    }

    private fun close() {
        findNavController().popBackStack()
    }

    companion object {
        private const val FILENAME_FORMAT = "yyyy-MM-dd-HH-mm-ss-SSS"
        const val CAMERA_ERROR_RESULT = "CAMERA_ERROR_RESULT"
        const val CAMERA_SUCCESS_RESULT = "CAMERA_SUCCESS_RESULT"
    }
}