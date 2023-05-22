package com.example.cstechtask.data.dto

import com.example.cstechtask.domain.model.CoachingSummaryData
import com.example.cstechtask.domain.model.CreditReportInfoData
import com.example.cstechtask.domain.model.DonutData

data class DonutDto(
    val accountIDVStatus: String,
    val creditReportInfo: CreditReportInfoDto,
    val dashboardStatus: String,
    val personaType: String,
    val coachingSummary: CoachingSummaryDto,
    val augmentedCreditScore: Long? = null,
)

data class CoachingSummaryDto(
    val activeTodo: Boolean,
    val activeChat: Boolean,
    val numberOfTodoItems: Long,
    val numberOfCompletedTodoItems: Long,
    val selected: Boolean,
)

data class CreditReportInfoDto(
    val score: Long,
    val scoreBand: Long,
    val clientRef: String,
    val status: String,
    val maxScoreValue: Long,
    val minScoreValue: Long,
    val monthsSinceLastDefaulted: Long,
    val hasEverDefaulted: Boolean,
    val monthsSinceLastDelinquent: Long,
    val hasEverBeenDelinquent: Boolean,
    val percentageCreditUsed: Long,
    val percentageCreditUsedDirectionFlag: Long,
    val changedScore: Long,
    val currentShortTermDebt: Long,
    val currentShortTermNonPromotionalDebt: Long,
    val currentShortTermCreditLimit: Long,
    val currentShortTermCreditUtilisation: Long,
    val changeInShortTermDebt: Long,
    val currentLongTermDebt: Long,
    val currentLongTermNonPromotionalDebt: Long,
    val currentLongTermCreditLimit: Long? = null,
    val currentLongTermCreditUtilisation: Long? = null,
    val changeInLongTermDebt: Long,
    val numPositiveScoreFactors: Long,
    val numNegativeScoreFactors: Long,
    val equifaxScoreBand: Long,
    val equifaxScoreBandDescription: String,
    val daysUntilNextReport: Long,
)

fun DonutDto.toDonutData(): DonutData {
    return DonutData(
        accountIDVStatus = accountIDVStatus,
        dashboardStatus = dashboardStatus,
        personaType = personaType,
        augmentedCreditScore = augmentedCreditScore,
        coachingSummary = coachingSummary.toData(),
        creditReportInfo = creditReportInfo.toData(),

    )
}

fun CoachingSummaryDto.toData(): CoachingSummaryData {
    return CoachingSummaryData(
        activeTodo = activeTodo,
        activeChat = activeChat,
        numberOfTodoItems = numberOfTodoItems,
        numberOfCompletedTodoItems = numberOfCompletedTodoItems,
        selected = selected,

    )
}

fun CreditReportInfoDto.toData(): CreditReportInfoData {
    return CreditReportInfoData(
        score = score,
        scoreBand = scoreBand,
        clientRef = clientRef,
        status = status,
        maxScoreValue = maxScoreValue,
        minScoreValue = minScoreValue,
        monthsSinceLastDefaulted = monthsSinceLastDefaulted,
        hasEverDefaulted = hasEverDefaulted,
        monthsSinceLastDelinquent = monthsSinceLastDelinquent,
        hasEverBeenDelinquent = hasEverBeenDelinquent,
        percentageCreditUsed = percentageCreditUsed,
        percentageCreditUsedDirectionFlag = percentageCreditUsedDirectionFlag,
        changedScore = changedScore,
        currentShortTermDebt = currentShortTermDebt,
        currentShortTermNonPromotionalDebt = currentShortTermNonPromotionalDebt,
        currentShortTermCreditLimit = currentShortTermCreditLimit,
        currentShortTermCreditUtilisation = currentShortTermCreditUtilisation,
        changeInShortTermDebt = changeInShortTermDebt,
        currentLongTermDebt = currentLongTermDebt,
        currentLongTermNonPromotionalDebt = currentLongTermNonPromotionalDebt,
        currentLongTermCreditLimit = currentLongTermCreditLimit,
        currentLongTermCreditUtilisation = currentLongTermCreditUtilisation,
        changeInLongTermDebt = changeInLongTermDebt,
        numPositiveScoreFactors = numPositiveScoreFactors,
        numNegativeScoreFactors = numNegativeScoreFactors,
        equifaxScoreBand = equifaxScoreBand,
        equifaxScoreBandDescription = equifaxScoreBandDescription,
        daysUntilNextReport = daysUntilNextReport,

    )
}
