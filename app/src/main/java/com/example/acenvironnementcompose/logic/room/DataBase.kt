package com.example.acenvironnementcompose.logic.room

import android.database.sqlite.SQLiteDatabase
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.acenvironnement.room.ClientDao
import com.example.acenvironnement.room.MissionSheetDao
import com.example.acenvironnement.room.UserDao


    @Database(entities = [User::class, Client::class, MissionSheet::class, Quote::class, DiagnosticRecord::class], version = 4)
    abstract class AppDatabase : RoomDatabase() {

//        init {
//            SQLiteDatabase.load
//        }

        abstract fun clientDao(): ClientDao
        abstract fun userDao(): UserDao
        abstract fun missionSheetDao(): MissionSheetDao
    }

