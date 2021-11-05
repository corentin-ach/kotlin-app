package com.corentinach.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import com.corentinach.neighbors.R
import com.corentinach.neighbors.data.NeighborRepository
import com.corentinach.neighbors.databinding.AddNeighborBinding
import com.corentinach.neighbors.models.Neighbor

class AddNeighbourFragment : Fragment() {
    private lateinit var binding: AddNeighborBinding
    private lateinit var saveButton: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddNeighborBinding.inflate(inflater, container, false)
        val view = inflater.inflate(R.layout.add_neighbor, container, false)
        with(binding) {
            saveButton.setOnClickListener {
                addNeighbor()
            }
            return view
        }
    }

    private fun addNeighbor() {
        with(binding) {
            val id = (NeighborRepository.getInstance().getNeighbours().size + 1)
            val name = nameInput.text.toString()
            val image = imageInput.text.toString()
            val address = adressInput.text.toString()
            val telephone = telInput.text.toString()
            val description = aboutInput.text.toString()
            val webSite = webInput.text.toString()
            val neighbor =
                Neighbor(id.toLong(), name, image, address, telephone, description, false, webSite)
            NeighborRepository.getInstance().addNeighbor(neighbor)
        }
    }
}
