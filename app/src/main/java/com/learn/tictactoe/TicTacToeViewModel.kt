package com.learn.tictactoe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.learn.tictactoe.data.Game

class TicTacToeViewModel: ViewModel() {
    private var gameLiveData: MutableLiveData<Game> = MutableLiveData()
    private lateinit var game: Game

    fun initGame() {

    }


}