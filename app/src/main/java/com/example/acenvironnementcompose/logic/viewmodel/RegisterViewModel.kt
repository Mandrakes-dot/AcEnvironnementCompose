package com.example.acenvironnementcompose.logic.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.acenvironnement.room.UserDao
import com.example.acenvironnementcompose.logic.room.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class RegisterViewModel @Inject constructor(
    private val userDao: UserDao
) : ViewModel() {

    fun registerUser(user: User){

        viewModelScope.launch {
            withContext(Dispatchers.IO){
                userDao.registerUser(user)
            }
        }
    }
}