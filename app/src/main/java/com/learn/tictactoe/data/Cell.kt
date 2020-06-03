package com.learn.tictactoe.data

import androidx.lifecycle.MutableLiveData

class Cell(var xIndex: Int, var yIndex: Int, var cellType: MutableLiveData<CellType> = MutableLiveData<CellType>(CellType.EMPTY)) {


    fun resetCell() {
        cellType.value = CellType.EMPTY
    }

    fun getText() = cellType.value?.text
}

enum class CellType(val text: String) {
    X("X"), O("O"), EMPTY("")
}
