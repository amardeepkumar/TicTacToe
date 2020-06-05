package com.learn.tictactoe.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.learn.tictactoe.R

class Game(
    private val context: Context, val player1: Player = Player(),
    val player2: Player = Player(),
    private val gameCount: MutableLiveData<Int> = MutableLiveData(1),
    private val draw: MutableLiveData<Boolean> = MutableLiveData(false),
    private val winner: MutableLiveData<String> = MutableLiveData()
) {

    var player1Turn = true

    val board = Board()

    fun newGame() {
        draw.value = false
        player1Turn = true
        board.resetBoard()
        winner.value = ""
    }

    fun player1Wins() {
        player1.incrementPoint()
        setWinner(context.getString(R.string.player1_wins))
    }

    fun player2Wins() {
        player2.incrementPoint()
        setWinner(context.getString(R.string.player2_wins))
    }

    fun resetGame() {
        player1.reset()
        player2.reset()
        board.resetBoard()
        gameCount.value = 1
        draw.value = false
        player1Turn = true
    }

    fun incrementGameCount() {
        gameCount.value = gameCount.value?.inc()
    }

    fun getGameDraw(): LiveData<Boolean> = draw

    fun getGameCount(): LiveData<Int> = gameCount

    fun setDraw() {
        draw.value = true
    }

    fun getWinner(): LiveData<String> = winner

    private fun setWinner(player: String) {
        winner.value = player
    }
}

