package com.ericthecoder.neverhaveiever.ui.main

import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.SnackbarDefaults.backgroundColor
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ericthecoder.neverhaveiever.R
import com.ericthecoder.neverhaveiever.ui.main.theme.NeverHaveIEverTheme
import com.google.accompanist.insets.statusBarsPadding

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { MainScreen() }
    }
}

@Composable
fun IntroScreen() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        Image(
            painter = painterResource(id = R.drawable.logo_main_transparent),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(48.dp))

        GameModeButton()

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
fun TopBar() {
    Column(modifier = Modifier.statusBarsPadding()) {
        TopAppBar(
            backgroundColor = MaterialTheme.colors.primary,
            contentColor = contentColorFor(backgroundColor),
            elevation = 0.dp,
        ) {}
        Divider()
    }
}

@Composable
fun GameModeButton() {
    Card(
        modifier = Modifier
            .height(200.dp)
            .width(150.dp),
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

@Composable
fun MainScreen() {
    NeverHaveIEverTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colors.background),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            TopBar()
            IntroScreen()
        }
    }
}

@Preview(name = "Light Mode")
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    showBackground = true,
    name = "Dark Mode"
)
@Composable
fun DefaultPreview() { MainScreen() }
