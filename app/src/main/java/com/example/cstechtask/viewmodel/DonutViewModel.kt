package com.example.cstechtask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cstechtask.model.DonutData
import com.example.cstechtask.model.DonutDetailsRepositoryImpl
import kotlinx.coroutines.launch

class DonutViewModel : ViewModel() {

    private val donutRepo = DonutDetailsRepositoryImpl()
    private val _donutData = MutableLiveData<DonutData>()
    val donutData: MutableLiveData<DonutData>
        get() = _donutData

    init {
        getDonutDetails()
    }

    fun getDonutDetails() {
        viewModelScope.launch {
            val response = donutRepo.getDonutDetails()
            if (response.isSuccessful) {
                donutData.value = response.body()
            }
        }
    }
}