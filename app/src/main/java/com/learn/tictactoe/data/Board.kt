package com.learn.tictactoe.data

class Board(var roundCount: Int = 0,
    val cellArray: Array<Array<Cell>> = Array(3) {
    Array(3) {
        Cell()
    }
}) {

    fun incrementRoundCount() {
        roundCount = roundCount.inc()
    }

    fun setPlayer1CellType(xIndex: Int, yIndex: Int) = cellArray[xIndex][yIndex].setCellType(CellType.X)

    fun setPlayer2CellType(xIndex: Int, yIndex: Int)  = cellArray[xIndex][yIndex].setCellType(CellType.O)

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

        if (cellArray[0][0].getCellType().value  == cellArray[1][1].getCellType().value
            && cellArray[0][0].getCellType().value  == cellArray[2][2].getCellType().value
            && cellArray[0][0].getCellType().value != CellType.EMPTY) {
            return true
        }

        if (cellArray[0][2].getCellType().value  == cellArray[1][1].getCellType().value
            && cellArray[0][2].getCellType().value  == cellArray[2][0].getCellType().value
            && cellArray[0][2].getCellType().value != CellType.EMPTY) {
            return true
        }
        return false
    }

    private fun checkRows(): Boolean {
        for (row in cellArray) {
            if (row[0].getCellType().value == row[1].getCellType().value
                &&  row[1].getCellType().value == row[2].getCellType().value
                && row[1].getCellType().value != CellType.EMPTY) {
                return true
            }
        }
        return false
    }

    private fun checkColumns(): Boolean {
        for (i in 0..2) {
            if (cellArray[0][i].getCellType().value  == cellArray[1][i].getCellType().value
                && cellArray[0][i].getCellType().value  == cellArray[2][i].getCellType().value
                && cellArray[0][i].getCellType().value != CellType.EMPTY) {
                return true
            }
        }
        return false
    }
}