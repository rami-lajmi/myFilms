package com.example.myfilms.di

import com.example.myfilms.app.home.HomeViewModel
import com.example.myfilms.app.splashscreen.SplashScreenViewModel
import com.example.myfilms.services.MovieApiClient
import com.example.myfilms.services.MovieApiService
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel { HomeViewModel() }
    viewModel { SplashScreenViewModel() }
    single { MovieApiClient() }
}