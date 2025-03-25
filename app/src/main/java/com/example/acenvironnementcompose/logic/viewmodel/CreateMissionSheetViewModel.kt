package com.example.acenvironnementcompose.logic.viewmodel

import android.content.Context
import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acenvironnement.room.ClientDao
import com.example.acenvironnement.room.MissionSheetDao
import com.example.acenvironnementcompose.logic.model.MissionSheetsModel
import com.example.acenvironnementcompose.logic.pdf.PdfGenerator
import com.example.acenvironnementcompose.logic.room.Client
import com.example.acenvironnementcompose.logic.room.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class CreateMissionSheetViewModel @Inject constructor(
    private val pdfGenerator: PdfGenerator,
    private val clientDao: ClientDao
) : ViewModel() {

    private var _client = MutableStateFlow<Client?>(null)
    val client : StateFlow<Client?> = _client

    fun createMissionSheet(context: Context, clientId: Int,missionSheet: MissionSheetsModel){
        viewModelScope.launch {
            pdfGenerator.addTextToPdf(context,clientId,missionSheet)
        }
    }

    fun getClient(clientId: Int){
        viewModelScope.launch {
            val response =withContext(Dispatchers.IO){
                clientDao.getClientById(clientId)
            }
            _client.value = response
        }
    }

    fun updateClient(client: Client){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                clientDao.updateClient(client.copy(hasMission = true))
            }
        }
    }
}