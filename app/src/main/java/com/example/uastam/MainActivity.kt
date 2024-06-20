package com.example.uastam

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.uastam.ui.theme.UASTAMTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UASTAMTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "login") {
                    composable("login") { Login(navController) }
                    composable("signup") { daftar(navController) }
                    composable("forgot_password") { lupapw(navController) }
                    composable("resephome") {resephome(navController) }
                    composable("resepdetail/{resepId}") { backStackEntry ->
                        resepdetail(
                            navController,
                            backStackEntry.arguments?.getString("resepId")
                        )
                    }
                }
            }
        }
    }
}