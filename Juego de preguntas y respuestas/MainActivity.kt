package com.example.proyectoparcial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
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
                    // Un contenedor de superficie que usa el color de 'fondo' del tema
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   // Esta función configura el gráfico de navegación de la aplicación
                    QuizNavigation()
                }
            }
        }
    }
}

@Composable
fun QuizNavigation() {
    val navController = rememberNavController() // Remember and create a NavController
    NavHost(navController = navController, startDestination = "welcome") {
        composable("welcome") { WelcomeScreen(navController) }
        composable("question") { QuestionScreen(navController) }
        composable("answer") { AnswerScreen(navController) }
    }
}

@Composable
fun WelcomeScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column {
            Text("Bienvenido al Juego de Preguntas", style = MaterialTheme.typography.headlineMedium)
            Button(onClick = { navController.navigate("question") }, // Navigate to the QuestionScreen
                   modifier = Modifier.padding(top = 16.dp)) {
                Text("Empezar")
            }
        }
    }
}

@Composable
fun QuestionScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column {
            Text("Pregunta: ¿Cuál es la capital de Francia?", style = MaterialTheme.typography.headlineMedium)
            Button(onClick = { navController.navigate("answer") }, // Navigate to the AnswerScreen
                   modifier = Modifier.padding(top = 16.dp)) {
                Text("Responder París")
            }
        }
    }
}

@Composable
fun AnswerScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Column {
            Text("Respuesta: París es la capital de Francia.", style = MaterialTheme.typography.headlineMedium)
            Button(onClick = { navController.popBackStack("welcome", false) }, // Go back to the WelcomeScreen
                   modifier = Modifier.padding(top = 16.dp)) {
                Text("Volver al Inicio")
            }
        }
    }
}

