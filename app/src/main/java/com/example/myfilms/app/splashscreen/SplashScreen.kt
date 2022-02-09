package com.example.myfilms.app.splashscreen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.myfilms.R
import com.example.myfilms.app.home.HomeActivity
import com.example.myfilms.databinding.ActivitySplashScreenBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class SplashScreen : AppCompatActivity() {

    /**
     * Injected ViewModel
     */
    private val splashScreenViewModel: SplashScreenViewModel by viewModel()

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set databinding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_splash_screen)

        startActivity(Intent(this, HomeActivity::class.java))
        finish()
    }

}