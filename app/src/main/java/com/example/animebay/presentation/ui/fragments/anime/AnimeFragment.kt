package com.example.animebay.presentation.ui.fragments.anime

import android.util.Log
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.animebay.R
import com.example.animebay.databinding.FragmentAnimeBinding
import com.example.animebay.presentation.base.BaseFragment
import com.example.animebay.presentation.ui.adapters.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnimeFragment : BaseFragment<FragmentAnimeBinding, AnimeViewModel>(
    R.layout.fragment_anime
) {
    override val binding: FragmentAnimeBinding by viewBinding(FragmentAnimeBinding::bind)
    override val viewModel: AnimeViewModel by viewModels()
    private val animeAdapter = AnimeAdapter()


    override fun setupViews() {
        setupAdapter()
    }

    private fun setupAdapter() {
        binding.recycler.apply {
            adapter = animeAdapter
        }
    }

    override fun setupSubscribes() {
        viewModel.animeState.collectUiState(
            error = {
                Log.e("anime", it)
            },
            success = {
                animeAdapter.submitList(it)
                Log.e("success", it.toString())
            }
        )
    }

}