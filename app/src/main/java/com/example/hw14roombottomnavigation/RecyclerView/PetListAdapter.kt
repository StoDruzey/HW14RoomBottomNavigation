package com.example.hw14roombottomnavigation.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw14roombottomnavigation.databinding.ItemPetBinding

data class Pet()

class PetViewHolder(
    private val binding: ItemPetBinding
) : RecyclerView.ViewHolder(binding.root) {

}

class PetListAdapter : ListAdapter<Pet, PetViewHolder>(DIFF_UTIL) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetViewHolder {
        return PetViewHolder(
            ItemPetBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: PetViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<Pet>() {
            override fun areItemsTheSame(oldItem: Pet, newItem: Pet): Boolean {
                TODO("Not yet implemented")
            }

            override fun areContentsTheSame(oldItem: Pet, newItem: Pet): Boolean {
                TODO("Not yet implemented")
            }
        }
    }
}