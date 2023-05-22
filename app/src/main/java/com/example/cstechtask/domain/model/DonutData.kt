package com.example.cstechtask.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

data class DonutData(
    val accountIDVStatus: String,
    val creditReportInfo: CreditReportInfoData,
    val dashboardStatus: String,
    val personaType: String,
    val coachingSummary: CoachingSummaryData,
    val augmentedCreditScore: Long? = null,
)

data class CoachingSummaryData(
    val activeTodo: Boolean,
    val activeChat: Boolean,
    val numberOfTodoItems: Long,
    val numberOfCompletedTodoItems: Long,
    val selected: Boolean,
)

@Parcelize
data class CreditReportInfoData(
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
) : Parcelable
