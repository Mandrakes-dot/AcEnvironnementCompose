package com.example.acenvironnementcompose.logic.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.acenvironnement.room.ClientDao
import com.example.acenvironnementcompose.logic.room.Client
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel@Inject constructor(
    private val clientDao: ClientDao

) : ViewModel() {

    private val _clientList = MutableStateFlow<List<Client>>(emptyList())
    val clientList: StateFlow<List<Client>> = _clientList.asStateFlow()

    init {
        getClientList()
    }

    private fun getClientList(){

        viewModelScope.launch {
            withContext(Dispatchers.IO){

                val result = clientDao.getAllClient()

                _clientList.value = result
            }
        }
    }
}