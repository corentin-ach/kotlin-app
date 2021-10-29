package com.corentinach.neighbors.adapters

import com.corentinach.neighbors.models.Neighbor

interface ListNeighborHandler {
    fun onDeleteNeighbor(neighbor: Neighbor)
}
