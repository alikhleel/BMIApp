package com.alikhalil.bmiapp.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.alikhalil.bmiapp.NavigationItem
import com.alikhalil.bmiapp.components.CounterComponent
import com.alikhalil.bmiapp.components.HeightSlider
import com.alikhalil.bmiapp.components.SwitchGender


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BMIScreen(
    modifier: Modifier = Modifier,
    bmiViewModel: BMIViewModel = viewModel(), navController: NavController,

    ) {
    val bmiUiState by bmiViewModel.uiState.collectAsState()
    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text("BMI Calculator", fontWeight = FontWeight.Bold, letterSpacing = 1.sp) })
        },
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            SwitchGender(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f),
                selected = bmiUiState.selectedGender,
                onSelectedChange = { bmiViewModel.toggleSelectedGender() })
            Spacer(modifier = Modifier.size(16.dp))
            HeightSlider(modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .weight(1f),
                value = bmiUiState.height,
                onValueChange = { bmiViewModel.updateHeight(it) })
            Spacer(modifier = Modifier.size(16.dp))
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxHeight()
                    .weight(1f),

                ) {
                CounterComponent(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                    title = "Weight",
                    value = bmiUiState.weight,
                    onIncrement = { bmiViewModel.incrementWeight() },
                    onDecrement = { bmiViewModel.decrementWeight() })
                Spacer(modifier = Modifier.size(8.dp))
                CounterComponent(modifier = Modifier
                    .fillMaxSize()
                    .weight(1f),
                    title = "Age",
                    value = bmiUiState.age,
                    onIncrement = { bmiViewModel.incrementAge() },
                    onDecrement = { bmiViewModel.decrementAge() })
            }
            Spacer(modifier = Modifier.size(24.dp))
            Button(modifier = Modifier.fillMaxWidth(), shape = RectangleShape, onClick = {
                val bmi = bmiViewModel.calculateBMI()
                val category = bmiViewModel.calculateCategory()
                navController.navigate(NavigationItem.Result.route.plus("/bmi=${bmi}&category=${category}"))
            }) {
                Text(
                    modifier = Modifier.padding(8.dp),
                    text = "Calculate BMI",
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}
