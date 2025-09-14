package com.example.mycity.screens

import androidx.lifecycle.ViewModel
import com.example.mycity.data.PlaceDetailData
import com.example.mycity.data.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class CityViewModel: ViewModel() {

    val _uiState = MutableStateFlow(UiState())
    val uiState: StateFlow<UiState> = _uiState


    fun updateState(location: PlaceDetailData){
        _uiState.update {
            it.copy(selectedPlace = location)
        }
    }

    fun resetState(){
        _uiState.update {
            it.copy(selectedPlace = null)
        }
    }
}