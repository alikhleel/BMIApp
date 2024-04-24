package com.alikhalil.bmiapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier


@Composable
fun HeightSlider(
    modifier: Modifier = Modifier, value: Float, onValueChange: (Float) -> Unit
) {
    Card(modifier = modifier) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Height", style = MaterialTheme.typography.headlineLarge)
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Text(
                    text = value.toInt().toString(), style = MaterialTheme.typography.headlineMedium
                )
                Text(text = "cm", style = MaterialTheme.typography.headlineSmall)
            }
            Slider(
                value = value,
                onValueChange = onValueChange,
                valueRange = 0f..300f,
                steps = 300,
            )
        }
    }

}