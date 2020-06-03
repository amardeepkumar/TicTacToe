package com.learn.tictactoe.data

import androidx.lifecycle.MutableLiveData

class Board(
    private val liveDataCellArray: Array<Array<MutableLiveData<Cell>>> = Array(3) {
    Array(3) {
        MutableLiveData<Cell>()
    }
}) {

    fun resetBoard() {
        for (row in liveDataCellArray) {
            for (col in row) {
                col.value?.resetCell()
            }
        }
    }

    fun checkForWin() {
        //check for all rows
        checkRows()
        //check for cols
        checkColumns()
        //check diagonally
        checkDiagonally()
    }

    private fun checkDiagonally(): Boolean {

        if (liveDataCellArray[0][0].value == liveDataCellArray[1][1].value
            && liveDataCellArray[0][0].value == liveDataCellArray[2][2].value
            && liveDataCellArray[0][0].value?.cellType?.value != CellType.EMPTY) {
            return true
        }
        if (liveDataCellArray[0][2].value == liveDataCellArray[1][1].value
            && liveDataCellArray[0][2].value == liveDataCellArray[2][0].value
            && liveDataCellArray[0][2].value?.cellType?.value != CellType.EMPTY) {
            return true
        }
        return false
    }

    private fun checkRows(): Boolean {
        for (row in liveDataCellArray) {
            if (row[0].value?.getText() == row[1].value?.getText()
                &&  row[1].value?.getText() == row[2].value?.getText()
                && row[1].value?.cellType?.value != CellType.EMPTY) {
                return true
            }
        }
        return false
    }

    private fun checkColumns(): Boolean {
        for (i in 0..3) {
            if (liveDataCellArray[0][i].value == liveDataCellArray[1][i].value
                && liveDataCellArray[0][i].value == liveDataCellArray[2][i].value
                && liveDataCellArray[0][i].value?.cellType?.value != CellType.EMPTY) {
                return true
            }
        }
        return false
    }
}