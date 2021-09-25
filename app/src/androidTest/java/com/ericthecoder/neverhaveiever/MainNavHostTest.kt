package com.ericthecoder.neverhaveiever

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.ericthecoder.neverhaveiever.ui.main.MainNavHost
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Initial
import io.mockk.every
import io.mockk.mockk
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainNavHostTest {

  @get:Rule
  val composeTestRule = createComposeRule()

  private lateinit var navController: NavHostController
  private val gameViewModel: GameViewModel = mockk(relaxUnitFun = true) {
    every { uiState } returns Initial
  }

  @Before
  fun setup() {
    composeTestRule.setContent {
      navController = rememberNavController()
      MainNavHost(navController = navController, gameViewModel = gameViewModel)
    }
  }

  @Test
  fun mainNavHost() {
    composeTestRule
      .onNodeWithContentDescription("Home Screen")
      .assertIsDisplayed()
  }

  @Test
  fun mainNavHost_navigateToGame_viaUI() {
    composeTestRule
      .onNodeWithContentDescription("Game Deck")
      .performClick()
    composeTestRule
      .onNodeWithContentDescription("Game Screen")
      .assertIsDisplayed()
  }
}
