package com.corentinach.neighbors.fragments

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.corentinach.neighbors.NavigationListener
import com.corentinach.neighbors.R
import com.corentinach.neighbors.adapters.ListNeighborHandler
import com.corentinach.neighbors.adapters.ListNeighborsAdapter
import com.corentinach.neighbors.data.NeighborRepository
import com.corentinach.neighbors.databinding.ListNeighborsFragmentBinding
import com.corentinach.neighbors.models.Neighbor

class ListNeighborsFragment : Fragment(), ListNeighborHandler {
    private lateinit var recyclerView: RecyclerView
    private lateinit var binding: ListNeighborsFragmentBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ListNeighborsFragmentBinding.inflate(inflater, container, false)
        recyclerView = binding.neighborsList
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                requireContext(),
                DividerItemDecoration.VERTICAL
            )
        )
        binding.addNeighbor.setOnClickListener {
            (activity as? NavigationListener)?.let {
                it.showFragment(AddNeighbourFragment())
            }
        }
        /*(activity as? NavigationListener)?.let {
            it.updateTitle(R.string.all_list)
        }*/
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }

    override fun onDeleteNeighbor(neighbor: Neighbor) {

        activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it)
            builder.setMessage("Test")
                .setPositiveButton(
                    "CANCEL",
                    DialogInterface.OnClickListener { dialog, id ->
                        NeighborRepository.getInstance().removeNeighbor(neighbor)
                        refresh()
                    }
                )
                .setNegativeButton(
                    "DELETE",
                    DialogInterface.OnClickListener { dialog, id ->
                        // User cancelled the dialog
                    }
                )
            // Create the AlertDialog object and return it
            builder.create().show()
        }
    }

    private fun refresh() {
        val neighbors = NeighborRepository.getInstance().getNeighbours()
        val adapter = ListNeighborsAdapter(neighbors, this)
        recyclerView.adapter = adapter
    }
}
