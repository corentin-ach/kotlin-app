package com.corentinach.neighbors.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.corentinach.neighbors.data.NeighborRepository
import com.corentinach.neighbors.databinding.AddNeighborBinding
import com.corentinach.neighbors.models.Neighbor

class AddNeighbourFragment : Fragment() {
    private lateinit var binding: AddNeighborBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddNeighborBinding.inflate(inflater, container, false)
        val view = binding.root
        with(binding) {
            binding.btnSave.setOnClickListener {
                sendForm(view)
            }
            return view
        }
    }

    private fun sendForm(view: View) {
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
