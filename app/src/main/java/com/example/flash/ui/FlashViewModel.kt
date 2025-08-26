package com.example.flash.ui

import androidx.compose.runtime.collectAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class FlashViewModel: ViewModel() {

    private val _uiState= MutableStateFlow(FlashUiState())
    val uiState=_uiState.asStateFlow()

    fun updateStatus(name:String){
        _uiState.value=_uiState.value.copy(selectedCategory = name)
    }
}