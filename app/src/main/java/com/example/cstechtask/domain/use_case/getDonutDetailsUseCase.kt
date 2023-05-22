package com.example.cstechtask.domain.use_case

import com.example.cstechtask.domain.model.DonutData
import com.example.cstechtask.domain.repository.DonutRepository
import javax.inject.Inject

class GetDonutDetailsUseCase @Inject constructor(private val repository: DonutRepository) {

    suspend fun getDonutDetails(): DonutData {
        return repository.getDonutDetails()
    }
}
