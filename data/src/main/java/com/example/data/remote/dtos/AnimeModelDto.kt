package com.example.data.remote.dtos

import com.example.domain.models.AnimeModel
import com.google.gson.annotations.SerializedName

data class AnimeModelDto(
    @SerializedName("id")
    val id: String,
    @SerializedName("title")
    val title: String,

    @SerializedName("image")
    val image:String,

    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("director")
    val director: String,
    @SerializedName("producer")
    val producer: String,
    @SerializedName("release_date")
    val releaseDate: String,
    @SerializedName("running_time")
    val runningTime: String,
    @SerializedName("url")
    val url: String
)

fun AnimeModelDto.toDomain() = AnimeModel(
    id,title,image, originalTitle,
    description, director, producer,
    releaseDate, runningTime, url)