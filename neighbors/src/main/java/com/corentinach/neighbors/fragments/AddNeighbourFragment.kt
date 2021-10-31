package com.corentinach.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.corentinach.neighbors.R

class AddNeighbourFragment : Fragment() {
    private lateinit var saveButton: Button
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.add_neighbor, container, false)
        // var saveButton = view.findViewById(R.id.btn_save)
        return view
    }
}
