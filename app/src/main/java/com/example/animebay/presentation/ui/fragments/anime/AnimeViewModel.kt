package com.example.animebay.presentation.ui.fragments.anime

import com.example.animebay.presentation.base.BaseViewModel
import com.example.animebay.presentation.models.AnimeModelUI
import com.example.animebay.presentation.models.toUI
import com.example.domain.usecases.FetchAnimeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val fetchAnimeUseCase: FetchAnimeUseCase
) : BaseViewModel() {

    private val _animeState = mutableUIStateFlow<List<AnimeModelUI>>()
    val animeState = _animeState.asStateFlow()

    init {
        fetchAnime()
    }

    private fun fetchAnime() {
        fetchAnimeUseCase().collectRequest(_animeState) { it.map { it.toUI() } }
    }
}
