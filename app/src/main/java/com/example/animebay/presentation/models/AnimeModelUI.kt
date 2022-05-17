package com.example.animebay.presentation.models

import com.example.animebay.presentation.base.BaseDiffModel
import com.example.domain.models.AnimeModel

data class AnimeModelUI (
    override val id: String,
    val title: String,
    val image: String,
    val originalTitle: String,
    val description: String,
    val director: String,
    val producer: String,
    val releaseDate: String,
    val runningTime: String,
    val url: String
) : BaseDiffModel

fun AnimeModel.toUI() = AnimeModelUI(
    id, title,image, originalTitle,
    description, director, producer,
    releaseDate, runningTime, url)