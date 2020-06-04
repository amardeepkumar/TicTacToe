package com.learn.tictactoe.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class Cell(private val cellType: MutableLiveData<CellType> = MutableLiveData<CellType>(CellType.EMPTY)) {


    fun resetCell() {
        cellType.value = CellType.EMPTY
    }

    fun getCellType(): LiveData<CellType> = cellType

    fun setCellType(newCellType: CellType) {
        cellType.value = newCellType
    }
}

enum class CellType(val text: String) {
    X("X"), O("O"), EMPTY("")
}
