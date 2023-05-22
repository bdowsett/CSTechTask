package com.example.cstechtask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.cstechtask.domain.model.CreditReportInfoData
import com.example.cstechtask.viewmodel.DetailViewModel
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

class DetailViewModelTest {

    @get:Rule
    val taskExecutor = InstantTaskExecutorRule()

    private val viewModel = DetailViewModel()
    private val dataObserver: Observer<CreditReportInfoData> = mock()

    val testCreditReportInfo = CreditReportInfoData(
        score = 1870,
        scoreBand = 9010,
        clientRef = "principes",
        status = "non",
        maxScoreValue = 4188,
        minScoreValue = 7359,
        monthsSinceLastDefaulted = 7585,
        hasEverDefaulted = false,
        monthsSinceLastDelinquent = 1260,
        hasEverBeenDelinquent = false,
        percentageCreditUsed = 9468,
        percentageCreditUsedDirectionFlag = 4889,
        changedScore = 6099,
        currentShortTermDebt = 6317,
        currentShortTermNonPromotionalDebt = 7091,
        currentShortTermCreditUtilisation = 6447,
        changeInShortTermDebt = 9695,
        currentLongTermDebt = 6735,
        currentLongTermNonPromotionalDebt = 5019,
        currentLongTermCreditLimit = null,
        currentLongTermCreditUtilisation = null,
        changeInLongTermDebt = 6747,
        numPositiveScoreFactors = 8046,
        numNegativeScoreFactors = 2055,
        equifaxScoreBand = 4262,
        equifaxScoreBandDescription = "iusto",
        daysUntilNextReport = 6943, currentShortTermCreditLimit = 1969,
    )

    @Test
    fun setDatashouldupdatedetailDataLiveData() = runTest {
        viewModel.detailData.observeForever(dataObserver)
        viewModel.setData(testCreditReportInfo)

        assertEquals(testCreditReportInfo, viewModel.detailData.value)
        verify(dataObserver).onChanged(testCreditReportInfo)
    }
}
