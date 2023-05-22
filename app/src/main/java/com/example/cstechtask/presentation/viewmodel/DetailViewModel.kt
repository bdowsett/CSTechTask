package com.example.cstechtask.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cstechtask.domain.model.CreditReportInfoData

class DetailViewModel : ViewModel() {

    private val _detailData = MutableLiveData<CreditReportInfoData>()
    val detailData: MutableLiveData<CreditReportInfoData>
        get() = _detailData

    fun setData(data: CreditReportInfoData) {
        detailData.value = data
    }
}
