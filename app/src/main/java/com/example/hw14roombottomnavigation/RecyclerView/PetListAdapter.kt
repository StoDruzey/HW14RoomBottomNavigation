package com.example.hw14roombottomnavigation.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hw14roombottomnavigation.RoomDatabase.RoomPet
import com.example.hw14roombottomnavigation.databinding.ItemPetBinding

class PetViewHolder(
    private val binding: ItemPetBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(pet: RoomPet) {
        with(binding) {
            petId.text = pet.id.toString()
            petType.text = pet.petType
            petBreed.text = pet.petBreed
            petName.text = pet.petName
        }
    }
}

class PetListAdapter : ListAdapter<RoomPet, PetViewHolder>(DIFF_UTIL) {

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
        holder.bind(getItem(position))
    }

    companion object {
        private val DIFF_UTIL = object : DiffUtil.ItemCallback<RoomPet>() {
            override fun areItemsTheSame(oldItem: RoomPet, newItem: RoomPet): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: RoomPet, newItem: RoomPet): Boolean {
                return oldItem == newItem
            }
        }
    }
}