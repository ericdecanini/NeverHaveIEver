package com.ericthecoder.neverhaveiever.ui.main.game

import androidx.compose.ui.test.SemanticsMatcher
import androidx.compose.ui.test.SemanticsNodeInteraction
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasAnyChild
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Ended
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Initial
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Ongoing
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

class GameScreenTest {

  @get:Rule
  val composeTestRule = createComposeRule()

  @Test
  fun whenStateIsInitial_gameScreenIsEmpty() {
    composeTestRule.setContent {
      GameBody(state = Initial, onScreenClick = {}, onGameEnd = {})
    }

    composeTestRule
      .onNodeWithContentDescription("Game Screen")
      .assertHasNoChildren()
  }

  @Test
  fun whenStateIsOngoing_gameScreenDisplaysQuestion() {
    val question = "lorem ipsum"
    val state = Ongoing(question = question)
    composeTestRule.setContent {
      GameBody(state = state, onScreenClick = {}, onGameEnd = {})
    }

    composeTestRule
      .onNodeWithText(question)
      .assertExists()
  }

  @Test
  fun whenStateIsEnded_onGameEndIsCalled() {
    val onGameEnd: () -> Unit = mockk(relaxed = true)
    composeTestRule.setContent {
      GameBody(state = Ended, onScreenClick = {}, onGameEnd = onGameEnd)
    }

    verify { onGameEnd.invoke() }
  }

  @Test
  fun whenScreenIsClicked_onScreenClickIsCalled() {
    val onScreenClick: () -> Unit = mockk(relaxed = true)
    composeTestRule.setContent {
      GameBody(state = Initial, onScreenClick = onScreenClick, onGameEnd = {})
    }
    composeTestRule
      .onNodeWithContentDescription("Game Screen")
      .performClick()
    verify { onScreenClick.invoke() }
  }

  private fun SemanticsNodeInteraction.assertHasNoChildren() {
    assert(hasAnyChild(SemanticsMatcher("") { true }).not())
  }
}
