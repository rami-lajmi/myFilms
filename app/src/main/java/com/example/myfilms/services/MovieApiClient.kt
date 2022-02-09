package com.example.myfilms.services

import com.example.myfilms.utils.Constants
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient

class MovieApiClient {

    private lateinit var apiService: MovieApiService

    fun getApiService(): MovieApiService {

        val gson = GsonBuilder()
            .setLenient()
            .create()

        val client = OkHttpClient()

        // Initialize ApiService if not initialized yet
        if (!::apiService.isInitialized) {
            val retrofit = Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

            apiService = retrofit.create(MovieApiService::class.java)
        }

        return apiService
    }

}