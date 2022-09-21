package com.example.hw14roombottomnavigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.hw14roombottomnavigation.databinding.FragmentDbBotnavBinding

class DbBotnavFragment : Fragment() {
    private var _binding: FragmentDbBotnavBinding? = null
    private val binding get() = requireNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return FragmentDbBotnavBinding.inflate(inflater, container, false)
            .also { _binding = it }
            .root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        with(binding) {
            val nestedController =
                (childFragmentManager.findFragmentById(R.id.database_container) as NavHostFragment)
                    .navController
            botNav.setupWithNavController(nestedController)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}