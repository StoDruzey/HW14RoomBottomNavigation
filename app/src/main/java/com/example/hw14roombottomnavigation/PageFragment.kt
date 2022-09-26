package com.example.hw14roombottomnavigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.hw14roombottomnavigation.RecyclerView.PetListAdapter
import com.example.hw14roombottomnavigation.RoomDatabase.RoomPet
import com.example.hw14roombottomnavigation.RoomDatabase.RoomPetDao
import com.example.hw14roombottomnavigation.RoomDatabase.appDatabase
import com.example.hw14roombottomnavigation.databinding.FragmentPageBinding

class PageFragment : Fragment() {

    private var _binding: FragmentPageBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val petDao by lazy {
        requireContext().appDatabase.petDao()
    }

    private val adapter = PetListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return FragmentPageBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            recyclerView.adapter = adapter
            val pets = loadPets()
            adapter.submitList(pets)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun loadPets():List<RoomPet> {
        return petDao.loadPetsAll()
    }
}