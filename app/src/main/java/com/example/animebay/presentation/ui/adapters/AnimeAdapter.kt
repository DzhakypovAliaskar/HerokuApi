package com.example.animebay.presentation.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.animebay.databinding.ItemAnimeBinding
import com.example.animebay.presentation.base.BaseDiffUtils
import com.example.animebay.presentation.models.AnimeModelUI

class AnimeAdapter :
    ListAdapter<AnimeModelUI, AnimeAdapter.AnimeViewHolder>(BaseDiffUtils()) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnimeViewHolder {
        return AnimeViewHolder(
            ItemAnimeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }


    override fun onBindViewHolder(holder: AnimeViewHolder, position: Int) {
        getItem(position)?.let { holder.onBind(it) }
    }

    inner class AnimeViewHolder(private val binding: ItemAnimeBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(data: AnimeModelUI) {
            binding.apply {
                tvTitle.text = data.title
                tvOriginalTitle.text = data.originalTitle
                tvTitleDirector.text = data.director
                tvTitleProducer.text = data.producer
                tvTitleRunningTime.text = data.runningTime
                tvTitleReleaseDate.text = data.releaseDate
                tvDescription.text = data.description
                Glide.with(image).load(data.image).into(image)
            }
        }
    }
}