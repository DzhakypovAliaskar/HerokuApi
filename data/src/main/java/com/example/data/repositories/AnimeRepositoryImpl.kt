package com.example.data.repositories

import com.example.data.base.BaseRepository
import com.example.data.remote.apisevise.AnimeApi
import com.example.data.remote.dtos.toDomain
import com.example.domain.repositories.AnimeRepository
import javax.inject.Inject

class AnimeRepositoryImpl @Inject constructor(private val api: AnimeApi) :
    BaseRepository() , AnimeRepository {
       override fun fetchAnime() = doRequest {
            api.fetchAnime(). map {  it.toDomain()}}
    }