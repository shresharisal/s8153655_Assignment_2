package com.example.s8153655assignment2.presentation.dashboard

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.s8153655_assignment2.R
import com.example.s8153655_assignment2.data.model.Entity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : Fragment(R.layout.fragment_dashboard) {

    private val vm: DashboardViewModel by viewModels()
    private lateinit var adapter: DashboardAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val rv = view.findViewById<RecyclerView>(R.id.rvEntities)
        rv.layoutManager = LinearLayoutManager(requireContext())
        adapter = DashboardAdapter { e -> onItemClicked(e) }
        rv.adapter = adapter

        val key = arguments?.getString("keypass")
        if (key != null) vm.loadDashboard(key)

        vm.entities.observe(viewLifecycleOwner) { list ->
            adapter.submitList(list)
        }
    }

    private fun onItemClicked(entity: Entity) {
        val b = bundleOf(
            "property1" to entity.property1,
            "property2" to entity.property2,
            "description" to entity.description
        )
        findNavController().navigate(R.id.action_to_details, b)
    }
}
