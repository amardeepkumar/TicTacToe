package com.learn.tictactoe.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Cell(var xIndex: Int, var yIndex: Int, private val cellType: MutableLiveData<CellType> = MutableLiveData<CellType>(CellType.EMPTY)) {


    fun resetCell() {
        cellType.value = CellType.EMPTY
    }

    fun getText() = cellType.value?.text

    fun getCellType(): LiveData<CellType> {
        return cellType
    }

    fun setCellType(newCellType: CellType) {
        cellType.value = newCellType
    }
}

enum class CellType(val text: String) {
    X("X"), O("O"), EMPTY("")
}
