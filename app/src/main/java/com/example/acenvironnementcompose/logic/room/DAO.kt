package com.example.acenvironnement.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.acenvironnementcompose.logic.room.Client
import com.example.acenvironnementcompose.logic.room.MissionSheet
import com.example.acenvironnementcompose.logic.room.User


@Dao
interface ClientDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertClient(client: Client)

    @Query("SELECT * FROM Client WHERE id = :clientId")
    suspend fun getClientById(clientId: Int): Client?

    @Query("SELECT *  FROM client")
    fun getAllClient() : List<Client>

    @Update
    suspend fun updateClient(client: Client)

//    @Delete
//    suspend fun deleteClient(clientID:Int)
}

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.ABORT) // To avoid duplicate users
    suspend fun registerUser(user: User)

    @Query("SELECT * FROM user WHERE login = :login AND password = :password")
    suspend fun loginUser(login: String, password: String): User?

    @Update
    suspend fun updateUser(user: User)
}

@Dao
interface MissionSheetDao {

    @Insert
    suspend fun insertMissionSheet(missionSheet: MissionSheet)

}




