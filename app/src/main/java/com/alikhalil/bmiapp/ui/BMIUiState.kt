package com.alikhalil.bmiapp.ui

data class BMIUiState(
    val selectedGender: Boolean = false,
    val height: Float = 155f,
    val weight: Int = 55,
    val age: Int = 25
)