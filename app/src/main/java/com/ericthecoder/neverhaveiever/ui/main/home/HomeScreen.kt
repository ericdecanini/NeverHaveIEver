package com.ericthecoder.neverhaveiever.ui.main.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ericthecoder.neverhaveiever.R
import com.ericthecoder.neverhaveiever.ui.main.theme.NeverHaveIEverTheme

@Composable
fun HomeBody(
    onClickDeck: () -> Unit
) {
    Column(
        modifier = Modifier.semantics { contentDescription = "Home Screen" },
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(56.dp))
        Text(
            text = "Game Decks",
            style = MaterialTheme.typography.h4,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(48.dp))
        GameModeButton(
            modifier = Modifier.semantics { contentDescription = "Game Deck" },
            onClickDeck = onClickDeck
        )
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            "This is a development version of the app. More game modes will be available soon",
            modifier = Modifier.padding(horizontal = 16.dp),
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.4f),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun GameModeButton(
    modifier: Modifier = Modifier,
    onClickDeck: () -> Unit,
) {
    Card(
        modifier = modifier
            .height(200.dp)
            .width(150.dp)
            .clickable { onClickDeck() },
        backgroundColor = Color(0xFFFAFAFA),
        elevation = 4.dp,
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.gamemode_standard),
                contentDescription = null
            )

            Box(modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(Color(0xEE00A9A5))
                .height(50.dp)) {
                Text(
                    modifier = Modifier
                        .align(Alignment.Center),
                    text = "Normal",
                    color = Color.White,
                    style = MaterialTheme.typography.subtitle2,
                    fontSize = 20.sp,
                )
            }
        }
    }
}

@Preview
@Composable
fun GameModeButtonPreview() { GameModeButton {} }

@Preview
@Composable
fun HomeBodyPreview() {
    NeverHaveIEverTheme {
        Scaffold {
            HomeBody {}
        }
    }
}
