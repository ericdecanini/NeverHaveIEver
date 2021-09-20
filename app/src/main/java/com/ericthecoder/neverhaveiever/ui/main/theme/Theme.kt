package com.ericthecoder.neverhaveiever.ui.main.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = Indigo300,
    primaryVariant = Indigo700,
    secondary = NewYorkPink
)

private val LightColorPalette = lightColors(
    primary = Indigo500,
    primaryVariant = Indigo900,
    secondary = NewYorkPink
)

@Composable
fun NeverHaveIEverTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme)
        DarkColorPalette
    else
        LightColorPalette

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
