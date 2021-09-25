package com.ericthecoder.neverhaveiever.ui.main.game

import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Ended
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Initial
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Ongoing
import org.assertj.core.api.Assertions.assertThat
import org.junit.Before
import org.junit.Test

internal class GameViewModelTest {

  private lateinit var viewModel: GameViewModel

  @Before
  fun setUp() {
    viewModel = GameViewModel()
  }

  @Test
  fun `state is initial when view model is created`() {
    assertThat(viewModel.uiState).isEqualTo(Initial)
  }

  @Test
  fun `when start game with deck, random question is posted`() {
    val deck = listOf("one", "two")

    viewModel.startGame(deck)

    val state = viewModel.uiState
    assertThat(state).isInstanceOf(Ongoing::class.java)
    assertThat((state as Ongoing).question).isIn(deck)
  }

  @Test
  fun `when question posted after questions exhausted, game ends`() {
    val deck = listOf("last question")
    viewModel.startGame(deck)

    viewModel.postRandomQuestion()

    assertThat(viewModel.uiState).isEqualTo(Ended)
  }
}
