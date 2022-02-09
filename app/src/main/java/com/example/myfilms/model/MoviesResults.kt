package com.example.myfilms.model

import com.google.gson.annotations.SerializedName

data class MoviesResults(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("poster_path") val posterPath: String,
    @SerializedName("release_date") val releaseDate: String
)


