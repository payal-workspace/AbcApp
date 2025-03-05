package com.example.presentation.ui.theme

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

data class AppTypography(
    val headLineBold: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    val headlineNormal: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        color = Color.Black,
        fontSize = 30.sp
    ),
    val titleMedium: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Medium,
        color = Color.Black,
        fontSize = 25.sp
    ),
    val titleNormal: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        color = Color.Black,
        fontSize = 20.sp

    ),
    val bodyMedium: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Bold,
        color = Color.Black,
        fontSize = 19.sp
    ),
    val bodyNormal: TextStyle = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        color = Color.Black,
        fontSize =18.sp
    )

)
val LocalCustomTypography = staticCompositionLocalOf { AppTypography() }
