package com.example.hw14roombottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.hw14roombottomnavigation.databinding.FragmentFilldatabaseBinding

class FillDatabaseFragment : Fragment() {
    private var _binding: FragmentFilldatabaseBinding? = null
    private val binding get() = requireNotNull(_binding)

    private val petDao by lazy {
        requireContext().appDatabase.petDao()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentFilldatabaseBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}