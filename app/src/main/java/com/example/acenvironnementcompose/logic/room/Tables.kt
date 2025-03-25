package com.example.acenvironnementcompose.logic.room

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.example.acenvironnementcompose.logic.enums.DiagnosticEnum

@Entity(tableName = "user")
data class User(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val login: String,
    val password: String,
    val isConnected: Boolean?
)

@Entity(tableName = "Client")
data class Client(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val firstName: String,
    val lastName: String,
    val address: String,
    val ville: String,
    val postalCode: String,
    val phoneNumber: Long,
    val email: String,
    val gender: Int,
    val hasMission: Boolean?
)

@Entity(
    tableName = "mission_sheet",
    foreignKeys = [
        ForeignKey(
            entity = Client::class,
            parentColumns = ["id"],
            childColumns = ["clientId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class MissionSheet(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val clientId: Int,
    val filePath: String,
)



@Entity(
    tableName = "quote",
    foreignKeys = [
        ForeignKey(
            entity = Client::class,
            parentColumns = ["id"],
            childColumns = ["clientId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = User::class,
            parentColumns = ["id"],
            childColumns = ["userId"],
            onDelete = ForeignKey.SET_NULL
        )
    ]
)

data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val clientId: Int,
    val userId: Int?,
    val missionOrder :String,
    val housingType :String,
    val constructionYear: Int,
    val habitableSurface: Float,
    val email: String,
    val phoneNumber: String,
    val postalCode: String
)

@Entity(
    tableName = "diagnostics",
    foreignKeys = [
        ForeignKey(
            entity = MissionSheet::class,
            parentColumns = ["id"],
            childColumns = ["missionId"],
            onDelete = ForeignKey.CASCADE
        ),
        ForeignKey(
            entity = Quote::class,
            parentColumns = ["id"],
            childColumns = ["quoteId"],
            onDelete = ForeignKey.CASCADE
        )
    ]
)

data class DiagnosticRecord(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val missionId: Int?,
    val quoteId: Int?,
    val diagnosticType: String,
    val result: String
)


