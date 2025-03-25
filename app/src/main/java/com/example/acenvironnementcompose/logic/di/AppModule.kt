package com.example.acenvironnementcompose.logic.di

import android.content.Context
import android.content.SharedPreferences
import android.provider.ContactsContract.Data
import androidx.room.Database
import androidx.room.Room
import com.example.acenvironnement.room.ClientDao
import com.example.acenvironnement.room.MissionSheetDao
import com.example.acenvironnement.room.UserDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import com.example.acenvironnementcompose.logic.room.AppDatabase
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideSharedPreferences(@ApplicationContext context: Context): SharedPreferences {
        return context.getSharedPreferences("shared_pref", Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): AppDatabase{
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            "app_database"
        ).fallbackToDestructiveMigration() // Look it up apprently not good for final project
            .build()
    }

    @Provides
    fun provideClientDao(database: AppDatabase): ClientDao {
        return database.clientDao()
    }

    @Provides
    fun provideUserDao(database: AppDatabase): UserDao {
        return database.userDao()
    }

    @Provides
    fun provideMissionSheetDao(database: AppDatabase): MissionSheetDao {
        return database.missionSheetDao()
    }
}