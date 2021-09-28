package com.ericthecoder.neverhaveiever.ui.main.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import com.ericthecoder.neverhaveiever.ui.main.game.GameViewModel.UiState.*
import kotlin.random.Random

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
      uiState = Ongoing(question, generateBackgroundColour())
      availableQuestions.remove(question)
    } ?: endGame()
  }

  private fun generateBackgroundColour()
          = Color(Random.nextInt(0xEE), Random.nextInt(0xEE), Random.nextInt(0xEE))

  private fun endGame() {
    uiState = Ended
  }

  sealed class UiState {
    object Initial : UiState()
    class Ongoing(val question: String, val color: Color) : UiState()
    object Ended : UiState()
  }
}
