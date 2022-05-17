package com.example.data.remote.apisevise

import com.example.data.remote.dtos.AnimeModelDto
import retrofit2.http.GET

interface AnimeApi {
    @GET("/films")
    suspend fun fetchAnime(): List<AnimeModelDto>
}