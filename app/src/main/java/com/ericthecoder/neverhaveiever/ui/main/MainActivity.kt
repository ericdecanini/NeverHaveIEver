package com.ericthecoder.neverhaveiever.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ericthecoder.neverhaveiever.R
import com.ericthecoder.neverhaveiever.ui.main.home.HomeBody
import com.ericthecoder.neverhaveiever.ui.main.theme.NeverHaveIEverTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NeverHaveIEverApp() }
    }
}

@Composable
fun NeverHaveIEverApp() {
    NeverHaveIEverTheme {
        Scaffold(
            topBar = { TopBar() }
        ) { innerPadding ->
            HomeBody(Modifier.padding(innerPadding))
        }
    }
}

@Composable
fun TopBar() {
    TopAppBar(
        backgroundColor = MaterialTheme.colors.primary,
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
        ) {
            Image(
                painter = painterResource(R.drawable.logo_textonly),
                contentDescription = null,
                alignment = Alignment.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Preview
@Composable
fun TopBarPreview() {
    TopBar()
}
