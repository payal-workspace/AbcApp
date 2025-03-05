package com.example.presentation.ui.theme

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColorsPalette(
    val primary: Color = Color.Transparent,
    val secondary: Color = Color.Transparent,
    val tertiary: Color = Color.Transparent,
    val background: Color = Color.Transparent,
    val surface: Color = Color.Transparent,
    val onBackground: Color = Color.Transparent,
    val onSurface: Color = Color.Transparent,
    val error: Color = Color.Transparent,
    val success: Color = Color.Transparent,
    val info: Color = Color.Transparent,
    val warning: Color = Color.Transparent,
    val windowBackground: Color = Color.Transparent,
    val cardBg: Color = Color.Transparent,
    val black: Color = Color.Black,
    val white: Color = Color.White,
    val cyan: Color = Color.Cyan,
    val gray: Color = Color.Gray,
    val floatingButton: Color = Color.DarkGray
)

val LocalCustomColorsPalette = staticCompositionLocalOf { CustomColorsPalette() }

val OnLightCustomColorsPalette = CustomColorsPalette(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    windowBackground = windowBackground,
    cardBg = CardBg,
    black = Black,
    cyan = Cyan,
    gray = Gray,
    success = Color.Green,
    info = Color.Cyan,
    warning = Color.Yellow,
    white = White,
    onBackground = Color(0xFF1A237E),
    onSurface = Color(0xFFE53935),
    background = Color.White,
    floatingButton =  floatingButton
)

val OnDarkCustomColorsPalette = CustomColorsPalette(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    windowBackground = windowBackground,
    cardBg = CardBg,
    black = Black,
    cyan = Cyan,
    gray = Gray,
    success = Color.Green,
    info = Color.Cyan,
    warning = Color.Yellow,
    white = White,
    onBackground = Color(0xFF1E88E5),
    onSurface = Color(0xFFC62828),
    background = Color.Black,
    floatingButton =  floatingButton
)