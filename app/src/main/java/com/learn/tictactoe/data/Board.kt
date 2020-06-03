package com.learn.tictactoe.data

import androidx.lifecycle.MutableLiveData

class Board(var roundCount: Int = 0,
    val cellArray: Array<Array<Cell>> = Array(3) { row ->
    Array(3) { col ->
        Cell(row, col)
    }
}) {

    fun incrementRoundCount() {
        roundCount = roundCount.inc()
    }

    fun setPlayer1CellType(xIndex: Int, yIndex: Int) {
        cellArray[xIndex][yIndex].cellType?.value = CellType.X
    }

    fun setPlayer2CellType(xIndex: Int, yIndex: Int) {
        cellArray[xIndex][yIndex].cellType?.value = CellType.O
    }

    fun resetBoard() {
        for (row in cellArray) {
            for (col in row) {
                col.resetCell()
            }
        }
        roundCount = 0
    }

    fun checkForWin()  =
        checkRows() ||
        checkColumns() ||
        checkDiagonally()

    private fun checkDiagonally(): Boolean {

        if (cellArray[0][0].cellType.value  == cellArray[1][1].cellType.value
            && cellArray[0][0].cellType.value  == cellArray[2][2].cellType.value
            && cellArray[0][0].cellType.value != CellType.EMPTY) {
            return true
        }

        if (cellArray[0][2].cellType.value  == cellArray[1][1].cellType.value
            && cellArray[0][2].cellType.value  == cellArray[2][0].cellType.value
            && cellArray[0][2].cellType.value != CellType.EMPTY) {
            return true
        }
        return false
    }

    private fun checkRows(): Boolean {
        for (row in cellArray) {
            if (row[0].cellType.value == row[1].cellType.value
                &&  row[1].cellType.value == row[2].cellType.value
                && row[1].cellType.value != CellType.EMPTY) {
                return true
            }
        }
        return false
    }

    private fun checkColumns(): Boolean {
        for (i in 0..2) {
            if (cellArray[0][i].cellType.value  == cellArray[1][i].cellType.value
                && cellArray[0][i].cellType.value  == cellArray[2][i].cellType.value
                && cellArray[0][i].cellType.value != CellType.EMPTY) {
                return true
            }
        }
        return false
    }
}