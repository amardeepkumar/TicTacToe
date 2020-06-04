package com.learn.tictactoe

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.learn.tictactoe.data.CellType
import kotlinx.android.synthetic.main.activity_main.*

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

        reset_btn.setOnClickListener {ticTacToeViewModel.resetGame()}

        for (i in buttons.indices) {
            for (j in buttons.indices) {
                val buttonID = "button_$i$j"
                val resID = resources.getIdentifier(buttonID, "id", packageName)
                buttons[i][j] = findViewById<View>(resID) as Button?
                buttons[i][j]?.setOnClickListener(this)
                buttons[i][j]?.setTag(R.id.x_index, i)
                buttons[i][j]?.setTag(R.id.y_index, j)
                subscribeForCell(i, j)
            }
        }
        subscribeGameCount()
        subscribePlayer1Point()
        subscribePlayer2Point()
        subscribeForDraw()
        subscribeForWinner()
    }

    private fun subscribeForWinner() {
        ticTacToeViewModel.game.getWinner().observe(this, Observer{
            if (it.isNotEmpty()) {
                showGameResult(it) {
                    ticTacToeViewModel.launchNewGame()
                }
            }
        })
    }

    private fun showGameResult(message: String, okClickListener: () -> Unit) {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        builder.setMessage(message)
        builder.setPositiveButton(getString(R.string.ok)) { _, _ ->
            okClickListener()
        }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }

    private fun subscribeForDraw() {
        val drawObserver: Observer<Boolean> = Observer {
            if (it) {
                showGameResult(getString(R.string.draw)) {
                    ticTacToeViewModel.launchNewGame()
                }
            }
        }
        ticTacToeViewModel.game.getGameDraw().observe(this, drawObserver)
    }

    private fun subscribePlayer2Point() {
        val player2PointObserver: Observer<Int> = Observer {
            player2_points.text = it.toString()
        }
        ticTacToeViewModel.game.player2.getPlayerPoint().observe(this, player2PointObserver)
    }

    private fun subscribePlayer1Point() {
        val player1PointObserver: Observer<Int> = Observer {
            player1_point.text = it.toString()
        }
        ticTacToeViewModel.game.player1.getPlayerPoint().observe(this, player1PointObserver)
    }

    override fun onClick(v: View?) {
        ticTacToeViewModel.onCellClick((v as Button).text.toString(), v.getTag(R.id.x_index) as Int, v.getTag(R.id.y_index) as Int)
    }

    private fun subscribeGameCount() {
        val roundCountObserver: Observer<Int> = Observer {
            game_number.text = it.toString()
        }
        ticTacToeViewModel.game.getGameCount().observe(this, roundCountObserver)
    }

    private fun subscribeForCell(i: Int, j: Int) {
        val roundCountObserver: Observer<CellType> = Observer {
            buttons[i][j]?.text = it.text
        }
        ticTacToeViewModel.game.board.cellArray[i][j].getCellType().observe(this, roundCountObserver)
    }

}
