package com.learn.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var ticTacToeViewModel: TicTacToeViewModel
    private val buttons =
        Array(
            3
        ) { arrayOfNulls<Button>(3) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ticTacToeViewModel = ViewModelProvider(this).get(TicTacToeViewModel::class.java)
        ticTacToeViewModel.initGame()

        for (i in buttons.indices) {
            for (j in buttons.indices) {
                val buttonID = "button_$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                buttons[i][j] = findViewById<View>(resID) as Button?
                buttons[i][j]?.setOnClickListener(this)
            }
        }
    }

    override fun onClick(v: View?) {
        if ((v as Button).text.toString() != "") {
            return
        }
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show()
    }

}
