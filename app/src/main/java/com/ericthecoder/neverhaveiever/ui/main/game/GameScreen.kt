package com.ericthecoder.neverhaveiever.ui.main.game

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ericthecoder.neverhaveiever.ui.main.theme.NeverHaveIEverTheme

// TODO: Have an increased padding when on landscape orientation

@Composable
fun GameBody(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.primary)
            .padding(16.dp)
    ) {
        Text(
            text = "Never Have I Ever Lorem Ipsum Dolor Sat on Amet",
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h2,
            fontSize = 36.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(BiasAlignment(0f, -0.2f)),
        )
    }
}

@Preview
@Composable
fun GameBodyPreview() {
    NeverHaveIEverTheme {
        GameBody()
    }
}
