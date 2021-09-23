package com.ericthecoder.neverhaveiever.ui.main.game

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.ericthecoder.neverhaveiever.ui.main.game.data.FakeData

class GameViewModel : ViewModel() {

  var question by mutableStateOf("")

  init {
    postRandomQuestion()
  }

  fun postRandomQuestion() {
    val question = FakeData.cards.random()
    this.question = question
  }
}
