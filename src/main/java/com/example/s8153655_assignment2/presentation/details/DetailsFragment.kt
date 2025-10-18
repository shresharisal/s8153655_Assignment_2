package com.example.s8153655assignment2.presentation.details

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.s8153655_assignment2.R


class DetailsFragment : Fragment(R.layout.fragment_details) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val p1 = arguments?.getString("property1") ?: ""
        val p2 = arguments?.getString("property2") ?: ""
        val desc = arguments?.getString("description") ?: ""

        view.findViewById<TextView>(R.id.tvProp1).text = p1
        view.findViewById<TextView>(R.id.tvProp2).text = p2
        view.findViewById<TextView>(R.id.tvDesc).text = desc
    }
}
