package com.ericthecoder.neverhaveiever.ui.main.game

import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ericthecoder.neverhaveiever.ui.main.theme.NeverHaveIEverTheme

@Composable
fun GameBody(modifier: Modifier = Modifier) {
    val orientation = LocalConfiguration.current.orientation
    Box(
        modifier = modifier
            .background(MaterialTheme.colors.primary)
            .fillMaxSize()
            .padding(16.dp)
            .semantics { contentDescription = "Game Screen" },
        contentAlignment = Alignment.Center
    ) {
        Box(modifier = Modifier
            .fillMaxSize(if (orientation == ORIENTATION_LANDSCAPE) 0.8f else 1f)) {
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
}

@Preview
@Composable
fun GameBodyPreview() {
    NeverHaveIEverTheme {
        GameBody()
    }
}
