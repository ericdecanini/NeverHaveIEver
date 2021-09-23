package com.ericthecoder.neverhaveiever.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
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
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.ericthecoder.neverhaveiever.R
import com.ericthecoder.neverhaveiever.ui.main.game.GameBody
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel
import com.ericthecoder.neverhaveiever.ui.main.home.HomeBody
import com.ericthecoder.neverhaveiever.ui.main.theme.NeverHaveIEverTheme

class MainActivity : ComponentActivity() {

    private val gameViewModel by viewModels<GameViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent { NeverHaveIEverApp(gameViewModel) }
    }
}

@Composable
fun NeverHaveIEverApp(
    gameViewModel: GameViewModel
) {
    NeverHaveIEverTheme {
        val navController = rememberNavController()

        Scaffold(
            topBar = { TopBar() }
        ) { innerPadding ->
            MainNavHost(
                navController = navController,
                gameViewModel = gameViewModel,
                modifier = Modifier.padding(innerPadding)
            )
        }
    }
}

@Composable
fun MainNavHost(
    navController: NavHostController,
    gameViewModel: GameViewModel,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainScreen.Home.name,
        modifier = modifier
    ) {
        composable(MainScreen.Home.name) {
            HomeBody { navController.navigate(MainScreen.Game.name) }
        }
        composable(MainScreen.Game.name) {
            MainGameScreen(gameViewModel)
        }
    }
}

@Composable
fun MainGameScreen(viewModel: GameViewModel) {
    GameBody(
        question = viewModel.question,
        onScreenClick = viewModel::postRandomQuestion,
    )
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
