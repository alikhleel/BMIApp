package com.alikhalil.bmiapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp


@Composable
fun CounterComponent(
    modifier: Modifier = Modifier,
    title: String,
    value: Int,
    onIncrement: () -> Unit,
    onDecrement: () -> Unit
) {
    Card(
        modifier = modifier,
    ) {
        Column(
            Modifier.padding(8.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .weight(.6f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = title, style = MaterialTheme.typography.headlineLarge)
                Text(
                    text = value.toString(),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.headlineMedium
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxSize(.8f)
                    .weight(.4f),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                CounterButton(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.Blue, shape = CircleShape),
                    onClick = onDecrement,
                    icon = Icons.Default.Remove
                )
                Spacer(modifier = Modifier.size(16.dp))
                CounterButton(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize()
                        .weight(1f)
                        .aspectRatio(1f)
                        .background(Color.Blue, shape = CircleShape),
                    onClick = onIncrement,
                    icon = Icons.Default.Add
                )
            }
        }
    }
}

@Composable
fun CounterButton(modifier: Modifier = Modifier, onClick: () -> Unit, icon: ImageVector) {
    Button(
        modifier = modifier,
        onClick = onClick,
        contentPadding = PaddingValues(1.dp),
    ) {
        Icon(
            icon,
            contentDescription = icon.name,
            tint = MaterialTheme.colorScheme.onPrimary,
            modifier = Modifier.fillMaxSize(.5f)
        )
    }
}
