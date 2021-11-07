package com.corentinach.neighbors.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.URLUtil
import androidx.fragment.app.Fragment
import com.corentinach.neighbors.NavigationListener
import com.corentinach.neighbors.R
import com.corentinach.neighbors.data.NeighborRepository
import com.corentinach.neighbors.databinding.AddNeighborBinding
import com.corentinach.neighbors.models.Neighbor

class AddNeighbourFragment : Fragment(), TextWatcher {
    private lateinit var binding: AddNeighborBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (activity as? NavigationListener)?.let {
            it.updateTitle(R.string.new_neighbor)
        }
        binding = AddNeighborBinding.inflate(inflater, container, false)
        val view = binding.root
        with(binding) {
            binding.btnSave.setOnClickListener {
                saveNeighbor(view)
            }
            return view
        }
    }

    private fun saveNeighbor(view: View) {
        with(binding) {
            webInput.addTextChangedListener(this@AddNeighbourFragment)
            imageInput.addTextChangedListener(this@AddNeighbourFragment)
            val id = (NeighborRepository.getInstance().getNeighbours().size + 1)
            val name = nameInput.text.toString()
            val image = imageInput.text.toString()
            val address = adressInput.text.toString()
            val telephone = telInput.text.toString()
            val description = aboutInput.text.toString()
            val webSite = webInput.text.toString()
            var webInput = false
            var imageInput = false
            btnSave.isEnabled = false
            val neighbor =
                Neighbor(id.toLong(), name, image, address, telephone, description, false, webSite)

            if (URLUtil.isValidUrl(webSite)) {
                webInput = true
            } else binding.webLayout.error = "Erreur url"
            if (URLUtil.isValidUrl(image)) {
                imageInput = true
            } else binding.imageLayout.error = "Erreur url"

            if (webInput && imageInput) {
                NeighborRepository.getInstance().addNeighbor(neighbor)
            }
        }
    }

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        TODO("Not yet implemented")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        TODO("Not yet implemented")
    }

    override fun afterTextChanged(s: Editable?) {
        binding.btnSave.isEnabled =
            binding.nameInput.text.toString().isNotBlank() && binding.imageInput.text.toString()
            .isNotBlank() && binding.telInput.text.toString()
            .isNotBlank() && binding.webInput.text.toString()
            .isNotBlank() && binding.aboutInput.text.toString()
            .isNotBlank() && binding.adressInput.text.toString().isNotBlank()
    }
}
