package com.example.myfilms.model

import com.google.gson.annotations.SerializedName

data class MovieDetailsApiResponseEntity(
    @SerializedName("id") var id: Int,
    @SerializedName("title") var title: String,
    @SerializedName("original_title") var originalTitle: String,
    @SerializedName("backdrop_path")var backdropPath: String?,
    @SerializedName("production_companies") var productionCompanies: Array<MovieProdEntity>,
    @SerializedName("homepage") var homePage: String?,
    @SerializedName("overview")var overview: String?,
    @SerializedName("poster_path")var posterPath: String?,
    @SerializedName("vote_average") var voteAverage: Int
)
