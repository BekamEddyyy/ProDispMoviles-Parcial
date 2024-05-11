package com.example.proyectoparcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectoparcial.ui.theme.ProyectoParcialTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectoParcialTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    QuizNavigation()
                }
            }
        }
    }
}

@Composable
fun QuizNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("question") { QuestionScreen(navController) }
        composable("answer") { AnswerScreen(navController) }
    }
}

@Composable
fun WelcomeScreen(navController: androidx.navigation.NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("Bienvenido al Juego de Preguntas", style = MaterialTheme.typography.headlineMedium)
        // Agregar botón u otro elemento para navegar a la siguiente pantalla
    }
}

@Composable
fun QuestionScreen(navController: androidx.navigation.NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("Pregunta: ¿Cuál es la capital de Francia?", style = MaterialTheme.typography.headlineMedium)
        // Agregar opciones de respuesta y lógica para seleccionar una respuesta
    }
}

@Composable
fun AnswerScreen(navController: androidx.navigation.NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        Text("Respuesta: París es la capital de Francia.", style = MaterialTheme.typography.headlineMedium)
        // Proporcionar feedback sobre la respuesta y opción para volver a jugar o salir
    }
}
