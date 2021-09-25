package com.ericthecoder.neverhaveiever.ui.main.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Ended
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Initial
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.Ongoing

class GameViewModel : ViewModel() {

  var uiState by mutableStateOf<UiState>(Initial)

  private val availableQuestions = mutableListOf<String>()

  fun startGame(deck: List<String>) {
    availableQuestions.clear()
    availableQuestions.addAll(deck)
    postRandomQuestion()
  }

  fun postRandomQuestion() {
    availableQuestions.randomOrNull()?.let { question ->
      uiState = Ongoing(question)
      availableQuestions.remove(question)
    } ?: endGame()
  }

  private fun endGame() {
    uiState = Ended
  }

  sealed class UiState {
    object Initial : UiState()
    class Ongoing(val question: String) : UiState()
    object Ended : UiState()
  }
}
