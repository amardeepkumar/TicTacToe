package com.learn.tictactoe.data

import androidx.lifecycle.MutableLiveData

class Player(val playerName: String) {
    private val point: MutableLiveData<Int> = MutableLiveData()

    fun incrementPoint() {
        point.value = point.value?.inc()
    }

    fun reset() {
        point.value = point.value?.and(0)
    }
}