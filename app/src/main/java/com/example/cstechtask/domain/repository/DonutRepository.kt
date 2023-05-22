package com.example.cstechtask.domain.repository

import com.example.cstechtask.domain.model.DonutData

interface DonutRepository {
    suspend fun getDonutDetails(): DonutData
}

