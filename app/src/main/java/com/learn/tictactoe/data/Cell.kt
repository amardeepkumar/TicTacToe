package com.learn.tictactoe.data

import androidx.lifecycle.MutableLiveData

class Cell(var cellType: MutableLiveData<CellType>) {

    init {
        cellType.value = CellType.EMPTY
    }

    fun resetCell() {
        cellType.value = CellType.EMPTY
    }

    fun getText() = cellType.value?.text
}

enum class CellType(val text: String) {
    X("X"), O("O"), EMPTY("")
}
