package com.example.unscramble.ui.theme
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp

val fuenteTitulo = TextStyle(
    fontFamily = FontFamily.Default, 
    fontSize = 24.sp, //  para títulos
    color = Black, // del texto de título en naranja
    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
)

val fuenteSubtitulo = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 20.sp, 
    color = GrisOscuro
)

val fuenteNormal = TextStyle(
    fontFamily = FontFamily.Default,
    fontSize = 16.sp, 
    color = GrisOscuro
)
