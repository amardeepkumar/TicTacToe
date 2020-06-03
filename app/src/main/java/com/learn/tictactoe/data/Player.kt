package com.learn.tictactoe.data

import androidx.lifecycle.MutableLiveData

class Player(val playerName: String) {
    val point: MutableLiveData<Int> = MutableLiveData(0)

    fun incrementPoint() {
        point.value = point.value?.inc()
    }

    fun reset() {
        point.value = 0
    }
}