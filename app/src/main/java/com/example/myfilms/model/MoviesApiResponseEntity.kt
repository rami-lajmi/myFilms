package com.example.myfilms.model

import com.google.gson.annotations.SerializedName

data class MoviesApiResponseEntity(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<MoviesResults>,
    @SerializedName("total_pages") val pages: Int
)
