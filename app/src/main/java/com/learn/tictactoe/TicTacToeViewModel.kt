package com.learn.tictactoe

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.tictactoe.data.CellType
import com.learn.tictactoe.data.Game

class TicTacToeViewModel: ViewModel() {

    var game: Game = Game()

    fun onCellClick(btnText: String, xIndex: Int, yIndex: Int) {
        if (btnText != CellType.EMPTY.text) {
            return
        }
        if (game.player1Turn) {
            game.board.setPlayer1CellType(xIndex, yIndex)
        } else {
            game.board.setPlayer2CellType(xIndex, yIndex)
        }
        game.board.incrementRoundCount()

        when {
            game.board.checkForWin() -> {
                if (game.player1Turn) {
                    game.player1Wins()
                } else {
                    game.player2Wins()
                }
                game.board.resetBoard()
                game.incrementGameCount()
            }
            game.board.roundCount == 9 -> {
                //draw
                game.draw.value = true
                game.board.resetBoard()
                game.incrementGameCount()
            }
            else -> {
                game.player1Turn = game.player1Turn.not()
            }
        }
    }

    fun resetGame() {
        game.resetGame()
    }

}