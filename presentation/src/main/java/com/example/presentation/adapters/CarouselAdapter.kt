package com.example.presentation.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.SportsModelData
import com.example.presentation.databinding.CarouselItemBinding

class CarouselAdapter : ListAdapter<SportsModelData, CarouselAdapter.ViewHolder>(CarouselDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = CarouselItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(private val binding: CarouselItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SportsModelData) {
            binding.sportsImage.setBackgroundResource(item.sportsCategoryImageUrl)
        }
    }

    class CarouselDiffCallback : DiffUtil.ItemCallback<SportsModelData>() {
        override fun areItemsTheSame(oldItem: SportsModelData, newItem: SportsModelData): Boolean {
            return oldItem.sportsCategoryTitle == newItem.sportsCategoryTitle
        }

        override fun areContentsTheSame(oldItem: SportsModelData, newItem: SportsModelData): Boolean {
            return oldItem == newItem
        }
    }
}





