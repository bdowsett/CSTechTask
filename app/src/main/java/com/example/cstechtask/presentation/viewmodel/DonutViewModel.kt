package com.example.cstechtask.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.cstechtask.domain.model.DonutData
import com.example.cstechtask.domain.use_case.GetDonutDetailsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DonutViewModel @Inject constructor(private val getDonutsUseCase: GetDonutDetailsUseCase) : ViewModel() {

    private val _donutData = MutableLiveData<DonutData>()
    val donutData: MutableLiveData<DonutData>
        get() = _donutData

    fun getDonutDetails() {
        viewModelScope.launch {
            val response = getDonutsUseCase.getDonutDetails()

            donutData.value = response
        }
    }
}
