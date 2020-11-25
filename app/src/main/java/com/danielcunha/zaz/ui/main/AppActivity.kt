package com.danielcunha.zaz.ui.main

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.danielcunha.zaz.R
import com.danielcunha.zaz.databinding.ActivityAppBinding

class AppActivity : AppCompatActivity() {

    lateinit var binding: ActivityAppBinding

    @CallSuper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setBackgroundDrawable(ContextCompat.getDrawable(this, R.color.white))
        binding = DataBindingUtil.setContentView(this, R.layout.activity_app)
    }
}