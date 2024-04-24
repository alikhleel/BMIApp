package com.alikhalil.bmiapp.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// Set of Material typography styles to start with
val Typography1 = Typography(
    headlineLarge = TextStyle(
        fontSize = 48.sp,
        lineHeight = 56.sp,
        fontWeight = FontWeight.Bold,
    ),
    headlineMedium = TextStyle(
        fontSize = 42.sp,
        lineHeight = 52.sp,
        fontWeight = FontWeight.SemiBold
    ),
    bodyLarge = TextStyle(
        fontSize = 30.sp,

        fontWeight = FontWeight.Bold
    ),
    bodyMedium = TextStyle(
        fontSize = 26.sp,
        fontWeight = FontWeight.Bold
    ),
    bodySmall = TextStyle(
        fontSize = 24.sp,
        fontWeight = FontWeight.Bold
    ),
)