package com.example.cstechtask.data.repository

import com.example.cstechtask.data.DonutApi
import com.example.cstechtask.data.dto.toDonutData
import com.example.cstechtask.domain.model.DonutData
import com.example.cstechtask.domain.repository.DonutRepository
import javax.inject.Inject

class DonutRepositoryImpl @Inject constructor(private val api: DonutApi) : DonutRepository {
    override suspend fun getDonutDetails(): DonutData {
        return api.getDonutDetails().toDonutData()
    }
}
