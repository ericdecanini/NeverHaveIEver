package com.ericthecoder.neverhaveiever.ui.main.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.ericthecoder.neverhaveiever.R

val BalooPaaji2 = FontFamily(
    Font(R.font.baloopaaji2_regular),
    Font(R.font.baloopaaji2_medium, FontWeight.Medium),
    Font(R.font.baloopaaji2_semibold, FontWeight.SemiBold),
    Font(R.font.baloopaaji2_bold, FontWeight.Bold),
    Font(R.font.baloopaaji2_extrabold, FontWeight.ExtraBold)
)

val Typography = Typography(
    h1 = TextStyle(
        fontFamily = BalooPaaji2,
        fontWeight = FontWeight.Normal,
        fontSize = 96.sp,
        letterSpacing = (-1.5).sp
    ),
    h2 = TextStyle(
        fontFamily = BalooPaaji2,
        fontWeight = FontWeight.Light,
        fontSize = 60.sp,
        letterSpacing = (-0.5).sp
    ),
    h3 = TextStyle(
        fontFamily = BalooPaaji2,
        fontWeight = FontWeight.SemiBold,
        fontSize = 48.sp,
        letterSpacing = 0.sp
    ),
    h4 = TextStyle(
        fontFamily = BalooPaaji2,
        fontWeight = FontWeight.Medium,
        fontSize = 34.sp,
        letterSpacing = 0.25.sp
    ),
    h5 = TextStyle(
        fontFamily = BalooPaaji2,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        letterSpacing = 0.sp
    ),
    h6 = TextStyle(
        fontFamily = BalooPaaji2,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        letterSpacing = 0.15.sp
    ),
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
)
