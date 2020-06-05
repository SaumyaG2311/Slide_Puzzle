package com.example.slide_puzzle

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_puzzle.*
import java.lang.String

class fragment_puzzle : Fragment() {
    private val logTag = "PuzzleFragment"


    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(logTag, "onCreate")
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
        inflater.inflate(R.layout.fragment_puzzle, container, false)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val mainActivity: MainActivity = activity as MainActivity
        val puzzleBoardView = PuzzleBoardView(this!!.context!!, mainActivity.n)
        puzzle_container.addView(puzzleBoardView)

        button_new_game.setOnClickListener {
            puzzleBoardView.initGame()
            puzzleBoardView.invalidate()

        }
    }
}


