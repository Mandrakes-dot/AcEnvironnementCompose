package com.example.acenvironnementcompose.logic.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acenvironnement.room.ClientDao
import com.example.acenvironnementcompose.logic.room.Client
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject



@HiltViewModel
class AddClientViewModel@Inject constructor(
    private val clientDao: ClientDao
) : ViewModel() {

        fun addClient(newClient: Client) {


        viewModelScope.launch {
            withContext(Dispatchers.IO){
                clientDao.insertClient(newClient)
            }
        }
    }
}