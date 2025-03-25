package com.example.acenvironnementcompose.logic.viewmodel

import android.content.SharedPreferences
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.acenvironnement.room.UserDao
import com.example.acenvironnementcompose.logic.room.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.math.log

@HiltViewModel
class LoginViewModel@Inject constructor(
    private val userDao: UserDao
) : ViewModel() {

    private val _userFlow = MutableStateFlow<User?>(null)
    val userFlow = _userFlow.asStateFlow()

    fun loginUser(login:String, password: String){


        viewModelScope.launch {
            withContext(Dispatchers.IO){
                val user = userDao.loginUser(login,password)

                _userFlow.value = user
            }
        }
    }

    fun updateUser(user: User){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                userDao.updateUser(user.copy(isConnected = true))
            }
        }
    }
}