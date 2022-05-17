package com.example.domain.models

data class AnimeModel (
    val id: String,
    val title: String,
    val image: String,
    val originalTitle: String,
    val description: String,
    val director: String,
    val producer: String,
    val releaseDate: String,
    val runningTime: String,
    val url: String
)