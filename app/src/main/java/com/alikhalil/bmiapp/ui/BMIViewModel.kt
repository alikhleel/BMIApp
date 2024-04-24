package com.alikhalil.bmiapp.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update


class BMIViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(BMIUiState())
    val uiState: StateFlow<BMIUiState> = _uiState.asStateFlow()


    fun toggleSelectedGender() {
        _uiState.update { currentState ->
            currentState.copy(selectedGender = !currentState.selectedGender)
        }
    }

    fun updateHeight(height: Float) {
        _uiState.update { currentState ->
            currentState.copy(height = height)
        }
    }

    fun decrementAge() {
        _uiState.update { currentState ->
            currentState.copy(age = currentState.age - 1)
        }
    }

    fun incrementAge() {
        _uiState.update { currentState ->
            currentState.copy(age = currentState.age + 1)
        }
    }

    fun incrementWeight() {
        _uiState.update { currentState ->
            currentState.copy(weight = currentState.weight + 1)
        }
    }

    fun decrementWeight() {
        _uiState.update { currentState ->
            currentState.copy(weight = currentState.weight - 1)
        }
    }

    fun calculateBMI(): Float {
        val heightInMeters = uiState.value.height / 100
        return uiState.value.weight / (heightInMeters * heightInMeters)
    }

    fun calculateCategory(): String {
        val bmi = calculateBMI()
        return when {
            bmi < 18.5 -> "Underweight"
            bmi < 24.9 -> "Normal weight"
            bmi < 29.9 -> "Overweight"
            else -> "Obesity"
        }

    }


}