package com.example.myfilms.services

import com.example.myfilms.model.MovieDetailsApiResponseEntity
import com.example.myfilms.model.MoviesApiResponseEntity
import com.example.myfilms.utils.Constants
import retrofit2.Call
import retrofit2.http.*

interface MovieApiService {
    //Search movies
    @GET(Constants.SEARCH_MOVIE_URL)
    fun serachMovie(@Query ("api_key") apiKey: String = Constants.API_KEY, @Query ("query") query: String): Call<MoviesApiResponseEntity>

    //Movie details
    @GET(Constants.MOVIE_DETAILS_URL+"/{movie_id}")
    fun getMovieDetails(@Query ("api_key") apiKey: String = Constants.API_KEY, @Path(value = "movie_id", encoded = false) serial: String): Call<MovieDetailsApiResponseEntity>
}