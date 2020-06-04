package com.learn.tictactoe

import androidx.lifecycle.ViewModel
import com.learn.tictactoe.data.CellType
import com.learn.tictactoe.data.Game

class TicTacToeViewModel: ViewModel() {

    val game: Game = Game()

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
            }
            game.board.roundCount == 9 -> {
                //draw
                game.setDraw()
            }
            else -> {
                game.player1Turn = game.player1Turn.not()
            }
        }
    }

    fun resetGame() {
        game.resetGame()
    }

    fun launchNewGame() {
        game.incrementGameCount()
        game.newGame()
    }

}