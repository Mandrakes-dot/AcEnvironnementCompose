package com.example.acenvironnementcompose.logic.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acenvironnement.room.ClientDao
import com.example.acenvironnementcompose.logic.room.Client
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class ConsultClientViewModel@Inject constructor(
    private val clientDao: ClientDao
) : ViewModel() {

    private val _client = MutableStateFlow<Client?>(null)
    val client: StateFlow<Client?> = _client

    fun getClient(clientId: Int){

        viewModelScope.launch {
            withContext(Dispatchers.IO){

                val response = clientDao.getClientById(clientId)

                _client.value = response
            }
        }
    }

//    fun deleteClient(clientId: Int){
//        viewModelScope.launch {
//            withContext(Dispatchers.IO){
//
//                clientDao.deleteClient(clientId)
//            }
//        }
//    }
}