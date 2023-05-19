package com.example.cstechtask.model

import retrofit2.Response

interface DonutDetailsRepository {
    suspend fun getDonutDetails(): Response<DonutData>
}

class DonutDetailsRepositoryImpl() : DonutDetailsRepository {

    private val donutApiService: DonutApi = retrofit.create(DonutApi::class.java)

    override suspend fun getDonutDetails(): Response<DonutData> {
        return donutApiService.getDonutDetails()
    }
}
