package com.learn.tictactoe.data

import androidx.lifecycle.MutableLiveData

class Game(private val player1Name: String = "Player 1",
           private val player2Name: String = "Player 2",
           val player1: Player = Player(player1Name),
           val player2: Player = Player(player2Name),
           val gameCount: MutableLiveData<Int> = MutableLiveData(1),
           val draw: MutableLiveData<Boolean> = MutableLiveData(false)
) {

    var player1Turn = true

    val board = Board()

    fun newGame() {
        board.resetBoard()
    }

    fun player1Wins() {
        player1.incrementPoint()
    }

    fun player2Wins() {
        player2.incrementPoint()
    }

    fun resetGame() {
        player1.reset()
        player2.reset()
        board.resetBoard()
        gameCount.value = 1
        player1Turn = true
    }

    fun incrementGameCount() {
        gameCount.value = gameCount.value?.inc()
    }
}

