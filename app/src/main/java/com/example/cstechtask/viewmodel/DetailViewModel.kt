package com.example.cstechtask.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cstechtask.model.CreditReportInfo

class DetailViewModel : ViewModel() {

    private val _detailData = MutableLiveData<CreditReportInfo>()
    val detailData: MutableLiveData<CreditReportInfo>
        get() = _detailData

    fun setData(data: CreditReportInfo) {
        detailData.value = data
    }
}
