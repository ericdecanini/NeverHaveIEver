package com.ericthecoder.neverhaveiever.ui.main

enum class MainScreen {
  Home, Game;

  companion object {
    fun fromRoute(route: String?): MainScreen =
      when (route?.substringBefore("/")) {
        Home.name -> Home
        Game.name -> Game
        null -> Home
        else -> throw IllegalArgumentException("Route $route is not recognized.")
      }
  }
}
