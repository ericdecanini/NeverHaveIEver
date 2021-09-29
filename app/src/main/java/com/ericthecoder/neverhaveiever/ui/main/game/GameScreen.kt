package com.ericthecoder.neverhaveiever.ui.main.game

import android.annotation.SuppressLint
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.BiasAlignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.*
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Ended
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Ongoing
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Initial
import com.ericthecoder.neverhaveiever.ui.main.theme.NeverHaveIEverTheme

@Composable
fun GameBody(
    state: UiState,
    onScreenClick: () -> Unit,
    onGameEnd: @Composable () -> Unit,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .background((state as? Ongoing)?.color ?: MaterialTheme.colors.primary)
            .fillMaxSize()
            .noRippleClickable(onScreenClick)
            .padding(16.dp)
            .semantics { contentDescription = "Game Screen" },
        contentAlignment = Alignment.Center
    ) {
        GameContentFromState(
            state = state,
            onGameEnd = onGameEnd,
        )
    }
}

@Composable
fun GameContentFromState(
    state: UiState,
    onGameEnd: @Composable () -> Unit
) = when(state) {
    Initial -> { /* do nothing */ }
    is Ongoing -> OngoingState(question = state.question)
    Ended -> onGameEnd()
}

@Composable
fun OngoingState(question: String) {
    val orientation = LocalConfiguration.current.orientation

    Box(modifier = Modifier
        .fillMaxSize(if (orientation == ORIENTATION_LANDSCAPE) 0.8f else 1f)) {
        Text(
            text = question,
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
        GameBody(Ongoing("Lorem Ipsum", Color(0xFF00FF00)), {}, {})
    }
}

@SuppressLint("UnnecessaryComposedModifier")
private inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit) = composed {
    clickable(
        interactionSource = remember { MutableInteractionSource() },
        indication = null
    ) {
        onClick()
    }
}
