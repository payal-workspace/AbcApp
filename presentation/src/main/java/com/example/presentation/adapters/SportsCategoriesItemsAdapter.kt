package com.example.presentation.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.SportsModelLists
import com.example.presentation.databinding.SportsCategoryItemBinding

class SportsCategoryItemAdapter : ListAdapter<SportsModelLists, SportsCategoryItemAdapter.ViewHolder>(SportsCategoryDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SportsCategoryItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class ViewHolder(private val binding: SportsCategoryItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: SportsModelLists) {
            binding.sportsCategoryImage.setBackgroundResource(item.sportsImageUrl)
            binding.tvCategoryName.text = item.sportsTitle
            binding.tvCategoryDescription.text = item.sportsDescription
        }
    }

    class SportsCategoryDiffCallback : DiffUtil.ItemCallback<SportsModelLists>() {
        override fun areItemsTheSame(oldItem: SportsModelLists, newItem: SportsModelLists): Boolean {
            return oldItem.sportsTitle == newItem.sportsTitle
        }

        override fun areContentsTheSame(oldItem: SportsModelLists, newItem: SportsModelLists): Boolean {
            return oldItem == newItem
        }
    }
}




