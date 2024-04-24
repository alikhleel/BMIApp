package com.alikhalil.bmiapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ResultScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    bmi: Float = 0f,
    bmiCategory: String = "",
) {
    Scaffold(topBar = {
        TopAppBar(title = { Text("BMI Result") }, navigationIcon = {
            IconButton(onClick = { navController.popBackStack() }) {
                Icon(
                    Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Back",
                    modifier = Modifier.size(24.dp)
                )
            }
        })
    }) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp)
        ) {
            Text(
                buildAnnotatedString {
                    append("Your BMI is ")
                    withStyle(
                        MaterialTheme.typography.bodyMedium.toSpanStyle()
                            .copy(fontWeight = FontWeight.Bold)
                    ) {
                        append(bmi.toString())
                    }
                }, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal)
            )
            Spacer(modifier = Modifier.size(16.dp))
            Text(
                buildAnnotatedString {
                    append("You are in the ")
                    withStyle(
                        MaterialTheme.typography.bodyMedium.toSpanStyle().copy(
                            fontWeight = FontWeight.Bold,
                            color = when (bmiCategory) {
                                "Underweight" -> MaterialTheme.colorScheme.error
                                "Normal weight" -> MaterialTheme.colorScheme.primary
                                "Overweight" -> MaterialTheme.colorScheme.error
                                else -> MaterialTheme.colorScheme.onSurface
                            }
                        )
                    ) {
                        append(bmiCategory)
                    }
                }, style = MaterialTheme.typography.bodyMedium.copy(fontWeight = FontWeight.Normal)
            )
        }
    }
}
