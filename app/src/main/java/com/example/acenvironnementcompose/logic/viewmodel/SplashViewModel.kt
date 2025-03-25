package com.example.acenvironnementcompose.logic.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


    @HiltViewModel
    class SplashViewModel @Inject constructor(
    ) : ViewModel() {

        private val _goToOtherScreenSF = MutableSharedFlow<Boolean>(
            extraBufferCapacity = 1,
            onBufferOverflow = BufferOverflow.DROP_OLDEST
        )

        val goToOtherScreenSF = _goToOtherScreenSF.asSharedFlow()

        fun navigate(){
            viewModelScope.launch {

                delay(2000)

                _goToOtherScreenSF.emit(true)
            }
        }
    }
