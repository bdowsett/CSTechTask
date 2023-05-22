package com.example.cstechtask

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.example.cstechtask.domain.model.CoachingSummaryData
import com.example.cstechtask.domain.model.CreditReportInfoData
import com.example.cstechtask.domain.model.DonutData
import com.example.cstechtask.domain.use_case.GetDonutDetailsUseCase
import com.example.cstechtask.presentation.viewmodel.DonutViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mockito.mock
import org.mockito.Mockito.verify

@OptIn(ExperimentalCoroutinesApi::class)
class DonutViewModelTest {

    @get:Rule
    val taskExecutor = InstantTaskExecutorRule()

    @get:Rule
    val coroutinesTestRule = CoroutinesTestRule()

    private val testDonutData = DonutData(
        accountIDVStatus = "perpetua",
        creditReportInfo = CreditReportInfoData(
            score = 3932,
            scoreBand = 5488,
            clientRef = "idque",
            status = "inceptos",
            maxScoreValue = 3459,
            minScoreValue = 4181,
            monthsSinceLastDefaulted = 6787,
            hasEverDefaulted = false,
            monthsSinceLastDelinquent = 7328,
            hasEverBeenDelinquent = false,
            percentageCreditUsed = 4101,
            percentageCreditUsedDirectionFlag = 5768,
            changedScore = 4405,
            currentShortTermDebt = 7512,
            currentShortTermNonPromotionalDebt = 5435,
            currentShortTermCreditUtilisation = 4215,
            changeInShortTermDebt = 5465,
            currentLongTermDebt = 7301,
            currentLongTermNonPromotionalDebt = 9448,
            currentLongTermCreditLimit = null,
            currentLongTermCreditUtilisation = null,
            changeInLongTermDebt = 8617,
            numPositiveScoreFactors = 5797,
            numNegativeScoreFactors = 4108,
            equifaxScoreBand = 8641,
            equifaxScoreBandDescription = "homero",
            daysUntilNextReport = 8876, currentShortTermCreditLimit = 3349,
        ),
        dashboardStatus = "et",
        personaType = "iuvaret",
        coachingSummary = CoachingSummaryData(
            activeTodo = false,
            activeChat = false,
            numberOfTodoItems = 7306,
            numberOfCompletedTodoItems = 8418,
            selected = false,
        ),
        augmentedCreditScore = null,
    )

    private val dataObserver: Observer<DonutData> = mock()
    private var getDonutDetailsUseCase: GetDonutDetailsUseCase = mock()
    private val viewModel = DonutViewModel(getDonutDetailsUseCase)

    @Test
    fun testLiveDataIsSet() = runTest {
        viewModel.donutData.observeForever(dataObserver)
        given(getDonutDetailsUseCase.getDonutDetails()).willReturn(testDonutData)

        // Method under test
        viewModel.getDonutDetails()

        verify(dataObserver).onChanged(testDonutData)
        assertEquals(testDonutData, viewModel.donutData.value)
    }
}
