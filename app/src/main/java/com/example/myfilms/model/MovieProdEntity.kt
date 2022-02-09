package com.example.myfilms.model

import com.google.gson.annotations.SerializedName

data class MovieProdEntity(
    @SerializedName("id")val id: Int,
    @SerializedName("name") var name: String,
    @SerializedName("logo_path")var logoPath: String?,
    @SerializedName("origin_country") var originCountry: String
)
