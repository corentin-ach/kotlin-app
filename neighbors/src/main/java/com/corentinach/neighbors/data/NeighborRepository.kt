package com.corentinach.neighbors.data

import DummyNeighborApiService
import NeighborApiService
import com.corentinach.neighbors.models.Neighbor

class NeighborRepository {
    private val apiService: NeighborApiService

    init {
        apiService = DummyNeighborApiService()
    }

    fun getNeighbours(): List<Neighbor> = apiService.neighbours
    fun removeNeighbor(neighbor: Neighbor) = apiService.deleteNeighbour(neighbor)
    fun addNeighbor(neighbor: Neighbor) = apiService.createNeighbour(neighbor)

    companion object {
        private var instance: NeighborRepository? = null
        fun getInstance(): NeighborRepository {
            if (instance == null) {
                instance = NeighborRepository()
            }
            return instance!!
        }
    }
}
