package com.alikhalil.bmiapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.alikhalil.bmiapp.R

@Composable
fun SwitchGender(
    modifier: Modifier = Modifier, selected: Boolean, onSelectedChange: (Boolean) -> Unit
) {
    Row(
        modifier = modifier
            .then(Modifier.height(200.dp))
            .fillMaxWidth()
    ) {
        val state = remember { mutableStateOf(selected) }
        Button(modifier = Modifier
            .fillMaxSize()
            .weight(1f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (state.value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.inversePrimary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            onClick = {
                state.value = true
                onSelectedChange(true)
            }) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painterResource(R.drawable.male),
                    contentDescription = "Male Icon",
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                )
                Text(
                    text = "Male", style = MaterialTheme.typography.headlineMedium
                )
            }
        }
        Spacer(modifier = Modifier.weight(0.01f))
        Button(modifier = Modifier
            .fillMaxSize()
            .weight(1f),
            shape = RectangleShape,
            colors = ButtonDefaults.buttonColors(
                containerColor = if (!state.value) MaterialTheme.colorScheme.primary else MaterialTheme.colorScheme.inversePrimary,
                contentColor = MaterialTheme.colorScheme.onPrimary
            ),
            onClick = {
                state.value = false
                onSelectedChange(false)
            }) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(
                    painterResource(R.drawable.female),
                    contentDescription = "Female Icon",
                    modifier = Modifier
                        .height(48.dp)
                        .width(48.dp)
                )
                Text(
                    text = "Female", style = MaterialTheme.typography.headlineMedium
                )
            }
        }
    }
}
