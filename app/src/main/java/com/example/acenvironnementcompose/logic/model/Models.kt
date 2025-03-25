package com.example.acenvironnementcompose.logic.model

import com.example.acenvironnementcompose.logic.enums.DiagnosticEnum


data class MissionSheetsModel(

    var missionOrder : String = "",
    val housingType :String = "",
    val constructionYear: Int = 0,
    val habitableSurface: Float = 0f,
    val stories: String = "",
    val fiscalNumber: Long = 1L,
    val cadastralSection: String = "",
    val heatingType: String = "",
    val address: String = "",
    val postalCode: String = "",
    val diagnosticList: List<DiagnosticModel> = diagList
)

data class DiagnosticModel(

    val type: DiagnosticEnum,
    var isSelected: Boolean
)


val diagList = DiagnosticEnum.values().map { diagnostics ->

    DiagnosticModel(diagnostics,false)
}