package com.alikhalil.bmiapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.compose.BMIAPPTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

            BMIAPPTheme {
                BMIApp()
            }
        }
    }
}

@Composable
fun BMIApp() {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        NavGraph(
            navController = rememberNavController()
        )
    }
}

